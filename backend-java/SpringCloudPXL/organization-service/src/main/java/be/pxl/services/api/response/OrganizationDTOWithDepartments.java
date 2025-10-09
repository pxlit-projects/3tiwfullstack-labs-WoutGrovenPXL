package be.pxl.services.api.response;

import java.util.List;

public record OrganizationDTOWithDepartments(Long id, String name, String address, List<DepartmentDTO> departments) {
}
