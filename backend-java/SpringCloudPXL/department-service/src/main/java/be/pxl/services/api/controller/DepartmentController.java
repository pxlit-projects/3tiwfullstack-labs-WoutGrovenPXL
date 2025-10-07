package be.pxl.services.api.controller;

import be.pxl.services.api.request.DepartmentRequest;
import be.pxl.services.api.response.DepartmentDTO;
import be.pxl.services.api.response.DepartmentDTOWithoutEmployee;
import be.pxl.services.services.IDepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/department")
@RequiredArgsConstructor
public class DepartmentController {

    private final IDepartmentService departmentService;

    @GetMapping
    public List<DepartmentDTO> getDepartments() {
        return departmentService.getDepartments();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DepartmentDTO> getDepartmentById(@PathVariable Long id){
        DepartmentDTO departmentDTO = departmentService.getDepartmentById(id);
        return new ResponseEntity<>(departmentDTO, HttpStatus.OK);
    }

    @GetMapping("/organization/{organizationId}/with-employees")
    public ResponseEntity<List<DepartmentDTO>> getDepartmentsByOrganizationId(@PathVariable Long organizationId){
        List<DepartmentDTO> departmentDTOS = departmentService.getDepartmentsByOrganizationId(organizationId);
        return new ResponseEntity<>(departmentDTOS, HttpStatus.OK);
    }

    @GetMapping("/organization/{organizationId}")
    public ResponseEntity<List<DepartmentDTOWithoutEmployee>> getDepartmentsByOrganizationIdWithoutEmployees(@PathVariable Long organizationId){
        List<DepartmentDTOWithoutEmployee> departmentDTOS = departmentService.getDepartmentsByOrganizationIdWithoutEmployees(organizationId);
        return new ResponseEntity<>(departmentDTOS, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> createDepartment(@RequestBody DepartmentRequest departmentRequest) {
        departmentService.createDepartment(departmentRequest);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }
}
