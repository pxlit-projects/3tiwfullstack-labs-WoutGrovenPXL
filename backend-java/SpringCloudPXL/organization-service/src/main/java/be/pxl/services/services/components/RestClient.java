package be.pxl.services.services.components;

import be.pxl.services.api.response.DepartmentDTO;
import be.pxl.services.api.response.EmployeeDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class RestClient {

    private final RestTemplate _restTemplate;

    @Value("${employee.service.url}")
    private String employeeServiceUrl;

    @Value("${department.service.url}")
    private String departmentServiceUrl;

    public RestClient(RestTemplate restTemplate){
        this._restTemplate = restTemplate;
    }

    public List<EmployeeDTO> getEmployeesByOrganization(Long organizationId) {
        ResponseEntity<List<EmployeeDTO>> response = _restTemplate.exchange(
                employeeServiceUrl + "/api/employee/organization/" + organizationId,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<EmployeeDTO>>() {}
        );
        return response.getBody();
    }

    public List<DepartmentDTO> getDepartmentsByOrganization(Long organizationId) {
        ResponseEntity<List<DepartmentDTO>> response = _restTemplate.exchange(
                departmentServiceUrl + "/api/department/organization/" + organizationId,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<DepartmentDTO>>() {}
        );
        return response.getBody();
    }




}
