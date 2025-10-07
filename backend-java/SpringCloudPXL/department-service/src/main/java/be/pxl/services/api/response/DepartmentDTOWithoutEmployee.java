package be.pxl.services.api.response;

public record DepartmentDTOWithoutEmployee(Long id, Long organizationId, String name, String position) {
}
