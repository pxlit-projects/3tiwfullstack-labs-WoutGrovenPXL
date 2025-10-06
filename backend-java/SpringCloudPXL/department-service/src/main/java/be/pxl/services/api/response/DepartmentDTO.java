package be.pxl.services.api.response;

import java.util.List;

public record DepartmentDTO(Long id, Long organizationId, String name, String position, List<EmployeeDTO> employees) {
}
