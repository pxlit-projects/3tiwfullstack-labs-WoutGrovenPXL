package be.pxl.services.services;

import be.pxl.services.api.request.OrganizationRequest;
import be.pxl.services.api.response.OrganizationDTO;
import be.pxl.services.domain.Organization;
import be.pxl.services.repository.OrganizationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrganizationService implements IOrganizationService{

    private final OrganizationRepository organizationRepository;

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
}
