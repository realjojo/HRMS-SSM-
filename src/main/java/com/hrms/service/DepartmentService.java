package com.hrms.service;

import com.hrms.DAO.DepartmentDAO;
import com.hrms.bean.Department;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class DepartmentService {

    @Autowired
    private DepartmentDAO departmentDAO;

    public int getDeptCount() {
        return departmentDAO.countDepts();
    }

    public Department getDeptById(Integer deptId) {
        return departmentDAO.selectDeptById(deptId);
    }

    public Department getDeptByName(String deptName) {
        return departmentDAO.selectDeptByName(deptName);
    }

    public Department getDeptByLeader(String deptLeader) {
        return departmentDAO.selectDeptByLeader(deptLeader);
    }

    public List<Department> getDeptList() {
        return departmentDAO.selectDeptList();
    }

    public List<Department> getDeptsByLimitAndOffset(Integer offset, Integer limit) {
        return departmentDAO.selectDeptsByLimitAndOffset(offset, limit);
    }

    public int updateDeptById(Integer deptId, Department department) {
        return departmentDAO.updateDeptById(deptId, department);
    }

    public int deleteDeptById(Integer deptId) {
        return departmentDAO.deleteDeptById(deptId);
    }

    public int insertDept(Department department) {
        return departmentDAO.insertDept(department);
    }
}
