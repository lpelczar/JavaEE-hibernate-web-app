package com.codecool.servlet;

import com.codecool.model.Customer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/list")
public class CustomerListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer(1, "sdsd", "sdsdd", "dssdds"));

        request.setAttribute("customers", customers);
        request.getRequestDispatcher("/WEB-INF/view/list-customers.jsp").forward(request,response);
    }
}
