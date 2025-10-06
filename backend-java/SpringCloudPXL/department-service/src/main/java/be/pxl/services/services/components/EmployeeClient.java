package be.pxl.services.services.components;

import be.pxl.services.api.response.EmployeeDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class EmployeeClient {

    private final RestTemplate _restTemplate;

    @Value("${employee.service.url}")
    private String employeeServiceUrl;

    public EmployeeClient(RestTemplate restTemplate) {
        this._restTemplate = restTemplate;
    }

    public List<EmployeeDTO> getEmployeesByDepartment(Long departmentId) {
        ResponseEntity<List<EmployeeDTO>> response = _restTemplate.exchange(
                employeeServiceUrl + "/api/employee/department/" + departmentId,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<EmployeeDTO>>() {}
        );
        return response.getBody();
    }

}
