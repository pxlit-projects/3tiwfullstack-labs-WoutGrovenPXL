package be.pxl.services.api.response;

public record EmployeeDTO(Long id, Long organisationId, Long departmentId, String name, int age , String position) {
}
