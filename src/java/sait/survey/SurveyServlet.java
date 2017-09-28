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
import sait.business.Survey;

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

        String url = "";
        String gender = request.getParameter("gender");
        String incomeString = request.getParameter("income");
        String ageString = request.getParameter("age");

        if (incomeString.equals("") || ageString.equals("")) {
            url = "/WEB-INF/survey.jsp";
            request.setAttribute("action", "survey");
            request.setAttribute("messageToSurvey", "Please ensure the survey is complete before submission.");
        } 
        else {
            url = "/WEB-INF/surveyComplete.jsp";
            request.setAttribute("action", "surveyComplete");
            int income = Integer.parseInt(request.getParameter("income"));
            int age = Integer.parseInt(request.getParameter("age"));

            String path = getServletContext().getRealPath("/WEB-INF/surveys.txt");

            // to append to a file
            PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(path, true)));

            String line = gender + "," + income + "," + age;
            pw.println(line.trim());
            pw.close();
        }

        getServletContext().getRequestDispatcher(url).forward(request, response);
    }
}
