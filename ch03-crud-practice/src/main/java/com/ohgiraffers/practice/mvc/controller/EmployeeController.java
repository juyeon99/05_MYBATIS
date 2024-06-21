package com.ohgiraffers.practice.mvc.controller;

import com.ohgiraffers.practice.mvc.dto.EmpJobDTO;
import com.ohgiraffers.practice.mvc.dto.EmpListByDeptDTO;
import com.ohgiraffers.practice.mvc.dto.EmployeeDTO;
import com.ohgiraffers.practice.mvc.dto.JobAvgSalaryDTO;
import com.ohgiraffers.practice.mvc.service.EmployeeService;
import com.ohgiraffers.practice.mvc.view.EmployeePrintResult;

import java.util.List;
import java.util.Map;

public class EmployeeController {
    private final EmployeePrintResult printResult;
    private final EmployeeService employeeService;

    public EmployeeController() {
        printResult = new EmployeePrintResult();
        employeeService = new EmployeeService();
    }

    public void selectAllEmployees() {
        List<EmployeeDTO> empList = employeeService.selectAllEmployees();

        // view로 전달
        if (empList != null){
            printResult.printEmployeeList(empList);
        } else {
            printResult.printErrorMessage("selectList");
        }
    }

    public void selectEmployeeById(Map<String, String> param){
        String empId = param.get("empId");
        EmployeeDTO emp = employeeService.selectEmployeeById(empId);

        // view로 전달
        if (emp != null){
            printResult.printEmployee(emp);
        } else {
            printResult.printErrorMessage("selectOne");
        }
    }

    public void selectEmployeeByName(Map<String, String> param){
        String empName = param.get("empName");
        EmployeeDTO emp = employeeService.selectEmployeeByName(empName);

        // view로 전달
        if (emp != null){
            printResult.printEmployee(emp);
        } else {
            printResult.printErrorMessage("selectOne");
        }
    }

    public void registerEmployee(Map<String, String> param) {
        String empId = param.get("empId");
        String empName = param.get("empName");
        String empNo = param.get("empNo");
        String jobCode = param.get("jobCode");
        String salLevel = param.get("salLevel");

        EmployeeDTO emp = new EmployeeDTO();
        emp.setEmpId(empId);
        emp.setEmpName(empName);
        emp.setEmpNo(empNo);
        emp.setJobCode(jobCode);
        emp.setSalLevel(salLevel);

        boolean result = employeeService.registerEmployee(emp);

        if (result){
            printResult.printSuccessMessage("insert");
        } else {
            printResult.printErrorMessage("insert");
        }
    }

    public void modifyEmployee(Map<String, String> param) {
        String empId = param.get("empId");
        String empName = param.get("empName");
        String empNo = param.get("empNo");
        String jobCode = param.get("jobCode");
        String salLevel = param.get("salLevel");

        EmployeeDTO emp = new EmployeeDTO();
        emp.setEmpId(empId);
        emp.setEmpName(empName);
        emp.setEmpNo(empNo);
        emp.setJobCode(jobCode);
        emp.setSalLevel(salLevel);

        boolean result = employeeService.modifyEmployee(emp);

        if (result){
            printResult.printSuccessMessage("update");
        } else {
            printResult.printErrorMessage("update");
        }
    }

    public void deleteEmployee(Map<String, String> param) {
        String empId = param.get("empId");

        boolean result = employeeService.deleteEmployee(empId);

        if (result){
            printResult.printSuccessMessage("delete");
        } else {
            printResult.printErrorMessage("delete");
        }
    }

    public void printAvgSalaryByJobCode() {
        List<JobAvgSalaryDTO> avgSalList = employeeService.printAvgSalaryByJobCode();

        // view로 전달
        if (avgSalList != null){
            printResult.printAvgSalaryList(avgSalList);
        } else {
            printResult.printErrorMessage("selectAvgSal");
        }
    }

    public void selectAllEmployeesByDeptCode() {
        List<EmployeeDTO> empDeptList = employeeService.selectAllEmployeesByDeptCode();

        // view로 전달
        if (empDeptList != null){
            printResult.printAllEmployeesByDeptCode(empDeptList);
        } else {
            printResult.printErrorMessage("selectAllEmployeesByDeptCode");
        }
    }

    public void selectEmployeeNameAndJobName() {
        List<EmpJobDTO> empJobList = employeeService.selectEmployeeNameAndJobName();

        // view로 전달
        if (empJobList != null){
            printResult.printEmployeeNameAndJobName(empJobList);
        } else {
            printResult.printErrorMessage("selectEmployeeNameAndJobName");
        }
    }
}
