package com.hrms.controller;

import com.hrms.bean.Department;
import com.hrms.service.DepartmentService;
import com.hrms.util.JsonMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/hrms/dept")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @RequestMapping(value = "/deletDept/{deptId}", method = RequestMethod.DELETE)
    public JsonMsg deletDept(@PathVariable("deptId") Integer deptId){
        int res = 0;
        if(deptId > 0) {
            res = departmentService.deleteDeptById(deptId);
        }
        if(res != 1) {
            return JsonMsg.fail().addInfo("department_delete_error", "删除部门信息异常");
        }
        return JsonMsg.success();
    }

    @RequestMapping(value = "/updateDept", method = RequestMethod.POST)
    public JsonMsg updateDept(@PathVariable("deptId") Integer deptId, Department department) {
        int res = 0;
        if(deptId > 0) {
            res = departmentService.updateDeptById(deptId, department);
        }
        if(res != 1){
            return JsonMsg.fail().addInfo("department_update_error", "更新部门信息异常");
        }
        return JsonMsg.success();
    }

    @RequestMapping(value = "/insertDept", method = RequestMethod.POST)
    public JsonMsg insertDept(Department department) {
        int res = departmentService.insertDept(department);
        if(res != 1) {
            return JsonMsg.fail().addInfo("department_insert_error", "新增部门信息异常");
        }
        return JsonMsg.success();
    }

    @RequestMapping(value = "/getDeptById/{deptId}", method = RequestMethod.GET)
    public JsonMsg getDeptById(@PathVariable("deptId") Integer deptId) {
        Department department = departmentService.getDeptById(deptId);
        if(department != null) {
            return JsonMsg.success();
        }else {
            return JsonMsg.fail();
        }
    }

}
