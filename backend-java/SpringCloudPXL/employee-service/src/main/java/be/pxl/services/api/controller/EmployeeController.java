package be.pxl.services.api.controller;

import be.pxl.services.api.request.EmployeeRequest;
import be.pxl.services.api.response.EmployeeDto;
import be.pxl.services.domain.Employee;
import be.pxl.services.services.IEmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employee")
@RequiredArgsConstructor
public class EmployeeController {

    private final IEmployeeService employeeService;

    @GetMapping
    public List<EmployeeDto> getEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDto> getEmpolyeeById(@PathVariable Long id){
        EmployeeDto employeeDto = employeeService.getEmployeeById(id);
        return ResponseEntity.ok(employeeDto);
    }

    @GetMapping("/department/{departmentId}")
    public ResponseEntity<List<EmployeeDto>> getEmployeeByDepartmentId(@PathVariable Long departmentId){
        List<EmployeeDto> employeeDtos = employeeService.getEmployeesByDepartmentId(departmentId);
        return ResponseEntity.ok(employeeDtos);
    }

    @GetMapping("/organization/{organizationId}")
    public ResponseEntity<List<EmployeeDto>> getEmployeesByOrganizationId(@PathVariable Long organizationId){
        List<EmployeeDto> employeeDtos = employeeService.getEmployeesByOrganizationId(organizationId);
        return ResponseEntity.ok(employeeDtos);
    }

    @PostMapping
    public ResponseEntity<Void> addEmployee(@RequestBody EmployeeRequest employeeRequest){
        employeeService.addEmployee(employeeRequest);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }
}
