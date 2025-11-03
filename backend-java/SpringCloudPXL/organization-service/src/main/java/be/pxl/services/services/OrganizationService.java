package be.pxl.services.services;

import be.pxl.services.api.request.OrganizationRequest;
import be.pxl.services.api.response.*;
import be.pxl.services.client.DepartmentClient;
import be.pxl.services.client.EmployeeClient;
import be.pxl.services.domain.Organization;
import be.pxl.services.repository.OrganizationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrganizationService implements IOrganizationService{

    private final OrganizationRepository organizationRepository;
    private final EmployeeClient employeeClient;
    private final DepartmentClient departmentClient;

    @Override
    public OrganizationDTO getOrganizationById(Long id) {
        return organizationRepository.findById(id).map(this::convertToOrganizationDto).orElse(null);
    }

    @Override
    public OrganizationDTO convertToOrganizationDto(Organization organization) {
        return new OrganizationDTO(
                organization.getId(),
                organization.getName(),
                organization.getAddress()
        );
    }

    @Override
    public void createOrganization(OrganizationRequest organizationRequest) {
        Organization organization = new Organization(
                organizationRequest.name(),
                organizationRequest.address()
        );

        organizationRepository.save(organization);
    }

    @Override
    public OrganizationDTOWithEmployees getOrganizationWithEmployees(Long organizationId) {
        List<EmployeeDTO> employees = employeeClient.getEmployeesByOrganization(organizationId);
        OrganizationDTO organizationDTO = getOrganizationById(organizationId);

        return new OrganizationDTOWithEmployees(
                organizationDTO.id(),
                organizationDTO.name(),
                organizationDTO.address(),
                employees
        );
    }

    @Override
    public OrganizationDTOWithDepartments getOrganizationWithDepartments(Long organizationId) {
        List<DepartmentDTO> departments = departmentClient.getDepartmentsByOranizationId(organizationId);
        OrganizationDTO organizationDTO = getOrganizationById(organizationId);

        return new OrganizationDTOWithDepartments(
                organizationDTO.id(),
                organizationDTO.name(),
                organizationDTO.address(),
                departments
        );
    }

    @Override
    public OrganizationDTOWithDepartmentsAndEmployees getOrganizationWithDepartmentsAndEmployees(Long organizationId) {
        List<DepartmentDTO> departments = departmentClient.getDepartmentsByOranizationId(organizationId);
        List<EmployeeDTO> employees = employeeClient.getEmployeesByOrganization(organizationId);
        OrganizationDTO organizationDTO = getOrganizationById(organizationId);

        return new OrganizationDTOWithDepartmentsAndEmployees(
                organizationDTO.id(),
                organizationDTO.name(),
                organizationDTO.address(),
                departments,
                employees
        );
    }
}
