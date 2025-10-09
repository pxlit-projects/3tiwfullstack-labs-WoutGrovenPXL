package be.pxl.services.services;

import be.pxl.services.api.request.OrganizationRequest;
import be.pxl.services.api.response.OrganizationDTO;
import be.pxl.services.api.response.OrganizationDTOWithDepartments;
import be.pxl.services.api.response.OrganizationDTOWithDepartmentsAndEmployees;
import be.pxl.services.api.response.OrganizationDTOWithEmployees;
import be.pxl.services.domain.Organization;

import java.util.List;

public interface IOrganizationService {

    OrganizationDTO getOrganizationById(Long id);

    OrganizationDTO convertToOrganizationDto(Organization organization);

    void createOrganization(OrganizationRequest organizationRequest);

    OrganizationDTOWithEmployees getOrganizationWithEmployees(Long organizationId);

    OrganizationDTOWithDepartments getOrganizationWithDepartments(Long organizationId);

    OrganizationDTOWithDepartmentsAndEmployees getOrganizationWithDepartmentsAndEmployees(Long organizationId);
}
