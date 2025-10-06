package be.pxl.services.services;

import be.pxl.services.api.request.DepartmentRequest;
import be.pxl.services.api.response.DepartmentDTO;
import be.pxl.services.domain.Department;

import java.util.List;

public interface IDepartmentService {

    List<DepartmentDTO> getDepartments();

    DepartmentDTO convertToDepartmentDto(Department department);

    void createDepartment(DepartmentRequest departmentRequest);


}
