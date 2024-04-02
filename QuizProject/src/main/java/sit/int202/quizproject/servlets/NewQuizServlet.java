package sit.int202.quizproject.servlets;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import sit.int202.quizproject.models.Question;
import sit.int202.quizproject.models.QuestionList;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "NewQuizServlet", value = "/new-quiz")
public class NewQuizServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        QuestionList questionList = new QuestionList();
        ArrayList<Question> question = questionList.getQuestions();
        request.setAttribute("question", question);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/quiz.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
