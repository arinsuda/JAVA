package int202.quizJpa.servlet;

import int202.quizJpa.Entities.Question;
import int202.quizJpa.Repositories.QuestionRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "ListQuestionServlet", value = "/list-questions")
public class ListQuestionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        QuestionRepository questionRepository = new QuestionRepository();
        List<Question> questions = questionRepository.findAll();
        req.setAttribute("questions", questions);
        getServletContext().getRequestDispatcher("/list_questions.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
