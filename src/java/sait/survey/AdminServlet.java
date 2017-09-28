/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sait.survey;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sait.business.User;

/**
 *
 * @author Administrator
 */
public class AdminServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        getServletContext().getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int numOfLines = 0;

        String url = "";
        String message = "";

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        User user = new User();
        user.setUsername(username);
        user.setPassword(password);

        String path = getServletContext().getRealPath("/WEB-INF/surveys.txt");

        // to read files
        BufferedReader br = new BufferedReader(new FileReader(new File(path)));

        if (user.getUsername().equals("") || user.getPassword().equals("")) {
            message = "Both values required!";
            request.setAttribute("username", user.getUsername());
            request.setAttribute("password", user.getPassword());
            request.setAttribute("errorMessage", message);
            url = "/WEB-INF/index.jsp";
        } else if (user.getUsername().equals("admin") && user.getPassword().equals("password")) {
            request.setAttribute("successMessage", message);
            url = "/WEB-INF/admin.jsp";
            
            while(br.readLine() != null)
            {
                ++numOfLines;
            }
            
            String numOfLinesString = Integer.toString(numOfLines);
            
            request.setAttribute("numOfSurveysCompleted", numOfLinesString);
            
        } else {
            message = "invalid username or password";
            request.setAttribute("username", user.getUsername());
            request.setAttribute("password", user.getPassword());
            request.setAttribute("errorMessage", message);
            url = "/WEB-INF/index.jsp";
        }

        getServletContext().getRequestDispatcher(url).forward(request, response);

        // TODO
    }

}
