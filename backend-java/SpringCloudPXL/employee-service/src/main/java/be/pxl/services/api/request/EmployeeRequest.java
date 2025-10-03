package be.pxl.services.api.request;

public record EmployeeRequest(Long organisationId, Long departmentId, String name, int age, String position) {
}
