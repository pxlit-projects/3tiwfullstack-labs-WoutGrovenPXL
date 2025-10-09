package be.pxl.services.api.response;

import java.util.List;

public record OrganizationDTOWithEmployees(Long id, String name, String address, List<EmployeeDTO> employees) {
}
