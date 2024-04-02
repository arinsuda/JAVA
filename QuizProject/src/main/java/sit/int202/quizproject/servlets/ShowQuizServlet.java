package sit.int202.quizproject.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import sit.int202.quizproject.models.Question;
import sit.int202.quizproject.models.QuestionList;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "ShowQuizServlet", value="/show-quiz")
public class ShowQuizServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        QuestionList questionList = new QuestionList();
        ArrayList<Question> questions = questionList.getQuestions();
        req.setAttribute("questions", questions);

        getServletContext().getRequestDispatcher("/quiz1.jsp").forward(req, resp);
    }
}
