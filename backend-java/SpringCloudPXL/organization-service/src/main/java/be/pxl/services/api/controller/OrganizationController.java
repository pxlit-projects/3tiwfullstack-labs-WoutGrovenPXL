package be.pxl.services.api.controller;

import be.pxl.services.api.request.OrganizationRequest;
import be.pxl.services.api.response.OrganizationDTO;
import be.pxl.services.services.IOrganizationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/organization")
@RequiredArgsConstructor
public class OrganizationController {


    private final IOrganizationService organizationService;

    @GetMapping("/{id}")
    public ResponseEntity<OrganizationDTO> getOrganizationById(@PathVariable Long id) {
        OrganizationDTO organizationDTO = organizationService.getOrganizationById(id);
        return new ResponseEntity<>(organizationDTO, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> addOrganization(@RequestBody OrganizationRequest organizationRequest) {
        organizationService.createOrganization(organizationRequest);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }


}
