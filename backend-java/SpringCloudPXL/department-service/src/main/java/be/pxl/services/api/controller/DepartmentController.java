package be.pxl.services.api.controller;

import be.pxl.services.api.request.DepartmentRequest;
import be.pxl.services.api.response.DepartmentDTO;
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

    @PostMapping
    public ResponseEntity<Void> createDepartment(@RequestBody DepartmentRequest departmentRequest) {
        departmentService.createDepartment(departmentRequest);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }



}
