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
import java.util.Arrays;

@WebServlet(name = "ShowAndCheckQuizServlet", value = "/show-check-quiz")
public class ShowAndCheckQuizServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        QuestionList questionList = new QuestionList();
        ArrayList<Question> questions = questionList.getQuestions();
        request.setAttribute("questions", questions);

        getServletContext().getRequestDispatcher("/quiz1.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        QuestionList questionList = new QuestionList();
        ArrayList<Question> questions = questionList.getQuestions();
        char[] answer = new char[questions.size() + 1];
        Arrays.fill(answer, ' ');

        int index = 1;
        int score = 0;
        for (Question question : questions) {
            String ans = request.getParameter("answer[" + index + "]");
            if (ans != null && ans.length() > 0) {
                answer[index] = ans.charAt(0);
                if ((answer[index] - 'a') == question.getCorrectIndex()) {
                    score++;
                }
            }
            index++;
        }

        request.setAttribute("questions", questions);
        request.setAttribute("answer", answer);
        request.setAttribute("score", score);
        getServletContext().getRequestDispatcher("/quiz1.jsp").forward(request, response);
    }
}
