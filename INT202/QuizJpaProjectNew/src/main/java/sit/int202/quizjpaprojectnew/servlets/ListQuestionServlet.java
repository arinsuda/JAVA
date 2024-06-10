package sit.int202.quizjpaprojectnew.servlets;

import java.io.*;
import java.util.List;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import sit.int202.quizjpaprojectnew.entities.Question;
import sit.int202.quizjpaprojectnew.repositories.QuestionRepository;


@WebServlet(name = "ListQuestionServlet", value = "/list-questions")
public class ListQuestionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        QuestionRepository questionRepo = new QuestionRepository();
        List<Question> questions = questionRepo.findAll();
        request.setAttribute("questions", questions);
        getServletContext().getRequestDispatcher("/list_questions.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}