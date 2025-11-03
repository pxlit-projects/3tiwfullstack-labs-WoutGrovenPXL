package be.pxl.services.services;

import be.pxl.services.api.request.DepartmentRequest;
import be.pxl.services.api.response.DepartmentDTO;
import be.pxl.services.api.response.DepartmentDTOWithoutEmployee;
import be.pxl.services.api.response.EmployeeDTO;
import be.pxl.services.client.EmployeeClient;
import be.pxl.services.domain.Department;
import be.pxl.services.repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DepartmentService implements IDepartmentService {

    private final DepartmentRepository departmentRepository;
    private final EmployeeClient employeeClient;

    @Override
    public List<DepartmentDTO> getDepartments() {
        return departmentRepository.findAll().stream().map(this::convertToDepartmentDto).toList();
    }

    @Override
    public DepartmentDTO convertToDepartmentDto(Department department) {
        List<EmployeeDTO> employees = employeeClient.getEmployeesByDepartmentId(department.getId());
        return new DepartmentDTO(department.getId(), department.getOrganizationId(), department.getName(), department.getPosition(), employees);
    }

    @Override
    public void createDepartment(DepartmentRequest departmentRequest) {
        Department department = new Department(
                departmentRequest.organizationId(),
                departmentRequest.name(),
                departmentRequest.position()
        );

        departmentRepository.save(department);
    }

    @Override
    public DepartmentDTO getDepartmentById(Long id) {
        return departmentRepository.findById(id).map(this::convertToDepartmentDto).orElse(null);
    }

    @Override
    public List<DepartmentDTO> getDepartmentsByOrganizationId(Long organizationId) {
        return departmentRepository.getDepartmentsByOrganizationId(organizationId).stream().map(this::convertToDepartmentDto).toList();
    }

    @Override
    public List<DepartmentDTOWithoutEmployee> getDepartmentsByOrganizationIdWithoutEmployees(Long organizationId) {
        return departmentRepository.getDepartmentsByOrganizationId(organizationId).stream().map(department -> {
            return new DepartmentDTOWithoutEmployee(
                    department.getId(),
                    department.getOrganizationId(),
                    department.getName(),
                    department.getPosition()
            );
        }).toList();
    }
}
