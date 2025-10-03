package be.pxl.services.api.response;

public record EmployeeDto(Long id, Long organisationId, Long departmentId, String name, int age , String position) {
}
