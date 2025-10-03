package be.pxl.services.services;

import be.pxl.services.api.request.EmployeeRequest;
import be.pxl.services.api.response.EmployeeDto;
import be.pxl.services.domain.Employee;

import java.util.List;

public interface IEmployeeService {
    List<EmployeeDto> getAllEmployees();

    EmployeeDto convertToEmployeeDto(Employee employee);

    void addEmployee(EmployeeRequest employeeRequest);

    EmployeeDto getEmployeeById(Long id);

    List<EmployeeDto> getEmployeesByDepartmentId(Long departmentId);

    List<EmployeeDto> getEmployeesByOrganizationId(Long organizationId);

}
