package sit.int202.quizjpaprojectnew;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import sit.int202.quizjpaprojectnew.entities.Answer;
import sit.int202.quizjpaprojectnew.entities.Question;
import sit.int202.quizjpaprojectnew.repositories.AnswerRepository;
import sit.int202.quizjpaprojectnew.repositories.QuestionRepository;

import java.util.List;

public class TestQuizjpa {
    public static void main(String[] args) {
//        testQuiz();
//        testQuizRepo();
//        testQuizAdd();
        testQuizAddAnswer();
    }

    public static void testQuiz(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
        EntityManager em = emf.createEntityManager();
        Question question = em.find(Question.class, 1);
        System.out.println(question);
    }

    public static void testQuizRepo(){
        QuestionRepository questionRepo = new QuestionRepository();
//        Question question = questionRepo.find(1L);
        List<Question> questionList = questionRepo.findAll();
        System.out.println(questionList);
    }

    public static void testQuizAdd(){
        QuestionRepository questionRepo = new QuestionRepository();
        Question question = new Question("5!");
        Answer answer = new Answer("24", 0);
        answer.setQuestion(question);
        question.addAnswer(answer);
        answer = new Answer("120", 1);
        answer.setQuestion(question);
        question.addAnswer(answer);
        answer = new Answer("720", 0);
        answer.setQuestion(question);
        question.addAnswer(answer);
        if (questionRepo.save(question)){
            System.out.println("Question is created successfully!");
        }else {
            System.out.println("There is something wrong for creating the Question!");
        }
    }

    public static void testQuizAddAnswer(){
        QuestionRepository questionRepo = new QuestionRepository();
        Question question = questionRepo.find(1L);
        AnswerRepository answerRepo = new AnswerRepository();
        Answer answer = new Answer("5", 0);
        answer.setQuestion(question);
        if (answerRepo.save(answer)){
            System.out.println("Answer is created successfully!");
        }else {
            System.out.println("There is something wrong for creating the Answer!");
        }
    }
}
