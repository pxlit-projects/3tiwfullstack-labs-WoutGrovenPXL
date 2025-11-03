package be.pxl.services.client;

import be.pxl.services.api.response.EmployeeDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "employee-service", url = "http://localhost:8081")
public interface EmployeeClient {

    @GetMapping("/api/employee/department/{departmentId}")
    List<EmployeeDTO> getEmployeesByDepartmentId(@PathVariable Long departmentId);
}
