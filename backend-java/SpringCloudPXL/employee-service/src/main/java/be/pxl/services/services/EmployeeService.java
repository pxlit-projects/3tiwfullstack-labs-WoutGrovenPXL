package be.pxl.services.services;

import be.pxl.services.api.request.EmployeeRequest;
import be.pxl.services.api.response.EmployeeDto;
import be.pxl.services.domain.Employee;
import be.pxl.services.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmployeeService implements IEmployeeService {

    private final EmployeeRepository employeeRepository;

    @Override
    public List<EmployeeDto> getAllEmployees() {
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
    public EmployeeDto getEmployeeById(Long id) {
        return employeeRepository.findById(id).map(this::convertToEmployeeDto).orElse(null);
    }

    @Override
    public List<EmployeeDto> getEmployeesByDepartmentId(Long departmentId) {

        List<EmployeeDto> employeeDtos = new ArrayList<>();

        List<Employee> employees = employeeRepository.findAllByDepartmentId(departmentId);

        for (Employee employee : employees) {
            employeeDtos.add(convertToEmployeeDto(employee));
        }

        return employeeDtos;
    }

    @Override
    public List<EmployeeDto> getEmployeesByOrganizationId(Long organizationId) {
        List<EmployeeDto> employeeDtos = new ArrayList<>();

        List<Employee> employees = employeeRepository.findAllByOrOrganizationId(organizationId);

        for (Employee employee : employees) {
            employeeDtos.add(convertToEmployeeDto(employee));
        }

        return employeeDtos;
    }

    @Override
    public EmployeeDto convertToEmployeeDto(Employee employee) {
        return new EmployeeDto(employee.getId(), employee.getOrganizationId(), employee.getDepartmentId(), employee.getName(), employee.getAge(), employee.getPosition());
    }




}
