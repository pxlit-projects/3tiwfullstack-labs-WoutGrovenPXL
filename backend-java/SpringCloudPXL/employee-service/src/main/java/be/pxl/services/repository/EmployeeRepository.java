package be.pxl.services.repository;

import be.pxl.services.api.response.EmployeeDto;
import be.pxl.services.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> findAllByDepartmentId(Long departmentId);
    List<Employee> findAllByOrOrganizationId(Long organizationId);
}
