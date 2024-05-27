package int202.quizJpa.servlet;

import int202.quizJpa.Entities.Answer;
import int202.quizJpa.Entities.Question;
import int202.quizJpa.Repositories.AnswerRepository;
import int202.quizJpa.Repositories.QuestionRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "EditQuestionServlet", value = "/edit-question")
public class EditQuestionServlet extends HttpServlet {
    private final QuestionRepository questionRepository = new QuestionRepository();
    private final AnswerRepository answerRepository = new AnswerRepository();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String strId = req.getParameter("id");
        Long id = parseId(strId);


            if (id != null) {
                Question question = questionRepository.find(id);
                if (question != null) {
                    req.setAttribute("question", question);
                    req.getRequestDispatcher("/question.jsp").forward(req, resp);
                    return;
                }
            }

        req.getRequestDispatcher("/question.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String strId = req.getParameter("id");
        Long id = parseId(strId);

        String text = req.getParameter("text");
        String action = req.getParameter("action");
        if (id != null) {

            if (action != null) {
                switch (action) {
                    case "new-question":
                        createNewQuestion(resp, req);
                        break;
                    case "edit-question":
                        editQuestion(id, text, resp, req);
                        break;
                    case "edit-answer":
                        editAnswer(req, resp, id);
                        break;
                    case "add-answer":
                        addAnswer(req, resp, id);
                        break;
                    case "remove-answer":
                        removeAnswer(req, resp, id);
                        break;
                    case "remove-question":
                        removeQuestion(req, resp, id);
                        break;
                    default:
                        break;
                }
            }
        }
    }

    private Long parseId(String strId) {
        try {
            return Long.parseLong(strId);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    private void createNewQuestion(HttpServletResponse resp, HttpServletRequest req) throws IOException {
        String text = req.getParameter("text");
        Question question = new Question(text);
        questionRepository.save(question);
        resp.sendRedirect("list-questions");
    }

    private void editQuestion(Long id, String text, HttpServletResponse resp, HttpServletRequest req) throws IOException {
        Question question = questionRepository.find(id);
        if (question!= null) {
            question.setQuestion(text);
            questionRepository.update(question);
        }
        resp.sendRedirect(req.getHeader("referer"));
    }

    private void editAnswer(HttpServletRequest req, HttpServletResponse resp, Long id) throws IOException {
        String oldText = req.getParameter("oldText");
        boolean isCorrect = req.getParameter("isCorrect") != null;

        Answer answer = answerRepository.find(id);
        if (answer != null) {
                answer.setAnswer(req.getParameter("text"));
                answer.setIsCorrect(isCorrect ? 1 : 0);
                answerRepository.update(answer);
        }
        resp.sendRedirect(req.getHeader("referer"));
    }

    private void addAnswer (HttpServletRequest req,HttpServletResponse resp, Long id) throws IOException {
        String text = req.getParameter("text");
        boolean isCorrect = req.getParameter("isCorrect") != null;

        Question question = questionRepository.find(id);
        if (question != null) {
            Answer answer = new Answer(text, isCorrect ? 1 : 0);
            answer.setQuestion(question);
            question.addAnswer(answer);
            answerRepository.save(answer);
        }
        resp.sendRedirect(req.getHeader("referer"));
    }

    private void removeAnswer (HttpServletRequest req,HttpServletResponse resp, Long id) throws IOException {
        Answer answer = answerRepository.find(id);
        if (answer != null) {
            answerRepository.delete(answer.getId());
        }
        resp.sendRedirect(req.getHeader("referer"));
    }

    private void removeQuestion (HttpServletRequest req,HttpServletResponse resp, Long id) throws IOException {
        Question question = questionRepository.find(id);
        if (question != null) {
            questionRepository.delete(question.getId());
        }
        resp.sendRedirect(req.getHeader("referer"));
    }
}


