package sit.int202.quizjpaprojectnew.servlets;

import java.io.*;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import sit.int202.quizjpaprojectnew.entities.Question;
import sit.int202.quizjpaprojectnew.repositories.QuestionRepository;


@WebServlet(name = "ManageQuestionServlet", value = "/manage-question")
public class ManageQuestionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String strId = request.getParameter("id");
        if (strId.equals("new")){
        request.getRequestDispatcher("/question.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        QuestionRepository questionRepo = new QuestionRepository();
        String strQuestion = request.getParameter("text");
        String action = request.getParameter("action");
        Question question = new Question(strQuestion);
        if (action.equals("add-question") &&  questionRepo.save(question)){
            response.sendRedirect("list-questions");
        }else {
            System.out.println("There is something wrong for creating the Question!");
        }

    }
}