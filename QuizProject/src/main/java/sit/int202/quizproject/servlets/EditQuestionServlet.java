package sit.int202.quizproject.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import sit.int202.quizproject.models.Answer;
import sit.int202.quizproject.models.Question;
import sit.int202.quizproject.models.QuestionList;

import java.io.IOException;

@WebServlet(name = "EditQuestionServlet", value = "/edit-question")
public class EditQuestionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        QuestionList questionList = new QuestionList();

        String strId = req.getParameter("id");

        if (strId != null && strId.length() > 0) {
            int id = Integer.parseInt(strId);
            Question question = questionList.find(id);
            if (question != null) {
                req.setAttribute("question", question);
                getServletContext().getRequestDispatcher("/edit_question.jsp").forward(req, resp);
            }
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String strId = req.getParameter("id");
        String text = req.getParameter("text");
        String action = req.getParameter("action");
        int id;
        try {
            id = Integer.parseInt(strId);
        } catch (NumberFormatException nfe) {
            id = -1;
        }

        QuestionList questionList = new QuestionList();
        Question question;
        String correct = req.getParameter("isCorrect");

        boolean isCorrect;
        if (correct != null) {
            isCorrect = true;
        } else {
            isCorrect = false;
        }

        if(action != null && action.equals("new-question")){
            question = new Question(text);
            questionList.addQuestion(question);
            resp.sendRedirect("list-question");
            return;
        } else if(action != null && action.equals("edit-question")){
            question = questionList.find(id);
            if(question != null){
                question.setQuestion(text);
            }
        } else if(action != null && action.equals("edit-answer")){
            String oldText = req.getParameter("oldText");

            question = questionList.find(id);
            if (question != null) {
                Answer answer = question.find(oldText);
                if(answer != null) {
                    answer.setAnswer(text);
                    answer.setCorrect(isCorrect);
                }
            }
        } else if (action != null && action.equals("add-answer")){
            question = questionList.find(id);
            if(question != null){
                Answer answer = new Answer(text, isCorrect);
                question.addAnswer(answer);
            }
        }

        resp.sendRedirect("edit-question?id=" + id);
    }
}
