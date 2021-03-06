package com.manhlee.controller;

import com.manhlee.dao.DepartmentDao;
import com.manhlee.dao.EmployeeDao;
import com.manhlee.model.Department;
import com.manhlee.model.DepartmentEntity;
import com.manhlee.model.EmployeeEntity;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "AddServlet", value = "/add")
public class AddServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Department > departmentList = new ArrayList<>();
        departmentList = DepartmentDao.findAllDepartment();
        request.setAttribute("departmentList",departmentList);
        request.getRequestDispatcher("/addpage.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        double salary = Double.parseDouble(request.getParameter("salary"));
        String departmentName = request.getParameter("departmentName");

//        DepartmentEntity departmentEntity = new DepartmentEntity();
//        departmentEntity.setName(departmentName);
//
//        EmployeeEntity employeeEntity = new EmployeeEntity();
//        employeeEntity.setName(name);
//        employeeEntity.setSalary(BigDecimal.valueOf(salary));
//        employeeEntity.setDepartmentByDepartmentId(departmentEntity);
//        EmployeeDao employeeDao=new EmployeeDao();
//        employeeDao.insertUseJPA(employeeEntity);
        EmployeeDao.addEmployee(name, salary, departmentName);
        response.sendRedirect("load");
    }
}
