package be.pxl.services.client;

import be.pxl.services.api.response.DepartmentDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "department-service", url = "http://localhost:8082")
public interface DepartmentClient {

    @GetMapping("/api/department/organization/{organizationId}")
    List<DepartmentDTO> getDepartmentsByOranizationId(@PathVariable Long organizationId);
}
