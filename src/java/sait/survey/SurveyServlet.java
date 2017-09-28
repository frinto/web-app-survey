/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sait.survey;

import java.io.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Administrator
 */
public class SurveyServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        getServletContext().getRequestDispatcher("/WEB-INF/survey.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String gender = request.getParameter("gender");
        int income = Integer.parseInt(request.getParameter("income"));
        int age = Integer.parseInt(request.getParameter("age"));

        String path = getServletContext().getRealPath("/WEB-INF/surveys.txt");

        // to append to a file
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(path, true)));
        
        String line = gender + "," + income + "," + age;
        pw.println(line.trim());
        pw.close();

        getServletContext().getRequestDispatcher("/WEB-INF/surveyComplete.jsp").forward(request, response);
    }
}
