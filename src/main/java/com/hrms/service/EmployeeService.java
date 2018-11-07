package com.hrms.service;

import com.hrms.DAO.EmployeeDAO;
import com.hrms.bean.Employee;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class EmployeeService {

    @Autowired
    private EmployeeDAO employeeDAO;

    public int getEmpCount() {
        return employeeDAO.countEmps();
    }

    public List<Employee> getEmpList(Integer offset, Integer limit) {
        return employeeDAO.selectByLimitAndOffset(offset, limit);
    }

    public Employee getEmpById(Integer empId) {
        return employeeDAO.selectOneById(empId);
    }

    public Employee getEmpByName(String empName) {
        return employeeDAO.selectOneByName(empName);
    }

    public int updateEmpById(Integer empId, Employee employee) {
        return employeeDAO.updateOneById(empId, employee);
    }

    public int deleteEmpById(Integer empId) {
        return employeeDAO.deleteOneById(empId);
    }

    public int insertEmp(Employee employee) {
        return employeeDAO.insertOne(employee);
    }
}
