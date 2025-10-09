package be.pxl.services.api.response;

import java.util.List;

public record OrganizationDTOWithDepartmentsAndEmployees(Long id, String name, String address, List<DepartmentDTO> departments, List<EmployeeDTO> employees) {
}
