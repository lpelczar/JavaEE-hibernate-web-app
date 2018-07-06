package com.codecool.servlet;

import com.codecool.service.CustomerService;
import com.codecool.service.CustomerServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/customer/list")
public class CustomerListServlet extends HttpServlet {

    private CustomerService customerService = new CustomerServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("customers", customerService.getCustomers());
        request.getRequestDispatcher("/WEB-INF/view/list-customers.jsp").forward(request,response);
    }
}
