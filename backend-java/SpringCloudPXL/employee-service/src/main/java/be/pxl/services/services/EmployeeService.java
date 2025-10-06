package be.pxl.services.services;

import be.pxl.services.api.request.EmployeeRequest;
import be.pxl.services.api.response.EmployeeDTO;
import be.pxl.services.domain.Employee;
import be.pxl.services.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService implements IEmployeeService {

    private final EmployeeRepository employeeRepository;

    @Override
    public List<EmployeeDTO> getAllEmployees() {
        return employeeRepository.findAll().stream().map(this::convertToEmployeeDto).toList();
    }

    @Override
    public void addEmployee(EmployeeRequest employeeRequest) {
        Employee employee = new Employee(
                employeeRequest.organisationId(),
                employeeRequest.departmentId(),
                employeeRequest.name(),
                employeeRequest.age(),
                employeeRequest.position()
        );

        employeeRepository.save(employee);
    }

    @Override
    public EmployeeDTO getEmployeeById(Long id) {
        return employeeRepository.findById(id).map(this::convertToEmployeeDto).orElse(null);
    }

    @Override
    public List<EmployeeDTO> getEmployeesByDepartmentId(Long departmentId) {

        List<EmployeeDTO> employeeDtos = new ArrayList<>();

        List<Employee> employees = employeeRepository.findAllByDepartmentId(departmentId);

        for (Employee employee : employees) {
            employeeDtos.add(convertToEmployeeDto(employee));
        }

        return employeeDtos;
    }

    @Override
    public List<EmployeeDTO> getEmployeesByOrganizationId(Long organizationId) {
        List<EmployeeDTO> employeeDtos = new ArrayList<>();

        List<Employee> employees = employeeRepository.findAllByOrOrganizationId(organizationId);

        for (Employee employee : employees) {
            employeeDtos.add(convertToEmployeeDto(employee));
        }

        return employeeDtos;
    }

    @Override
    public EmployeeDTO convertToEmployeeDto(Employee employee) {
        return new EmployeeDTO(employee.getId(), employee.getOrganizationId(), employee.getDepartmentId(), employee.getName(), employee.getAge(), employee.getPosition());
    }




}
