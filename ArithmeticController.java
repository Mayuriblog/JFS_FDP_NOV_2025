package com.arithmaticcontroller;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/operate")
public class ArithmeticController extends HttpServlet {

    public void doPost(HttpServletRequest req, HttpServletResponse res)
            throws IOException {
        try {
            double a = Double.parseDouble(req.getParameter("num1").trim());
            double b = Double.parseDouble(req.getParameter("num2").trim());
            String op = req.getParameter("operation");

            double result = 0;

            if ("add".equals(op)) result = a + b;
            else if ("sub".equals(op)) result = a - b;
            else if ("mul".equals(op)) result = a * b;
            else if ("div".equals(op)) result = a / b;

            req.setAttribute("result", result);

            req.getRequestDispatcher("/result.jsp")
                    .forward(req, res);

        } catch (Exception e) {
            res.getWriter().println("Invalid input");
        }
    }
}