package be.pxl.services.services;

import be.pxl.services.api.request.EmployeeRequest;
import be.pxl.services.api.response.EmployeeDTO;
import be.pxl.services.domain.Employee;

import java.util.List;

public interface IEmployeeService {
    List<EmployeeDTO> getAllEmployees();

    EmployeeDTO convertToEmployeeDto(Employee employee);

    void addEmployee(EmployeeRequest employeeRequest);

    EmployeeDTO getEmployeeById(Long id);

    List<EmployeeDTO> getEmployeesByDepartmentId(Long departmentId);

    List<EmployeeDTO> getEmployeesByOrganizationId(Long organizationId);

}
