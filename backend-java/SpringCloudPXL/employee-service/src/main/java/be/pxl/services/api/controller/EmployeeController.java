package be.pxl.services.api.controller;

import be.pxl.services.api.request.EmployeeRequest;
import be.pxl.services.api.response.EmployeeDTO;
import be.pxl.services.services.IEmployeeService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employee")
@RequiredArgsConstructor
public class EmployeeController {

    private final IEmployeeService employeeService;
    private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @GetMapping
    public List<EmployeeDTO> getEmployees() {
        logger.info("getEmployees called");
        return employeeService.getAllEmployees();
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDTO> getEmpolyeeById(@PathVariable Long id){
        EmployeeDTO employeeDto = employeeService.getEmployeeById(id);
        return ResponseEntity.ok(employeeDto);
    }

    @GetMapping("/department/{departmentId}")
    public ResponseEntity<List<EmployeeDTO>> getEmployeeByDepartmentId(@PathVariable Long departmentId){
        List<EmployeeDTO> employeeDtos = employeeService.getEmployeesByDepartmentId(departmentId);
        return ResponseEntity.ok(employeeDtos);
    }

    @GetMapping("/organization/{organizationId}")
    public ResponseEntity<List<EmployeeDTO>> getEmployeesByOrganizationId(@PathVariable Long organizationId){
        List<EmployeeDTO> employeeDtos = employeeService.getEmployeesByOrganizationId(organizationId);
        return ResponseEntity.ok(employeeDtos);
    }

    @PostMapping
    public ResponseEntity<Void> addEmployee(@RequestBody EmployeeRequest employeeRequest){
        employeeService.addEmployee(employeeRequest);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }
}
