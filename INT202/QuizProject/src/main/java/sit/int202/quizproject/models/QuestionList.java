package sit.int202.quizproject.models;

import java.util.ArrayList;

public class QuestionList {
    private static ArrayList<Question> questions = new ArrayList<>() ;

    static {
        Question q = new Question("1+2 = ?") ;
        q.addAnswer(new Answer("2"));
        q.addAnswer(new Answer("3",true));
        q.addAnswer(new Answer("4"));
        q.addAnswer(new Answer("5"));

        questions.add(q) ;

        q = new Question("1%2 = ?") ;
        q.addAnswer(new Answer("0"));
        q.addAnswer(new Answer("1",true));
        q.addAnswer(new Answer("null"));

        questions.add(q );

        q = new Question("1+2*3 = ?") ;
        q.addAnswer(new Answer("5"));
        q.addAnswer(new Answer("6"));
        q.addAnswer(new Answer("7",true));
        q.addAnswer(new Answer("8"));

        questions.add(q );

        q = new Question("sqrt(16) = ?") ;
        q.addAnswer(new Answer("1"));
        q.addAnswer(new Answer("2"));
        q.addAnswer(new Answer("3"));
        q.addAnswer(new Answer("4",true));

        questions.add(q );

        q = new Question("4! = ?") ;
        q.addAnswer(new Answer("6"));
        q.addAnswer(new Answer("12"));
        q.addAnswer(new Answer("24",true));
        q.addAnswer(new Answer("36"));

        questions.add(q );
    }

    public ArrayList<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(ArrayList<Question> newquestions) {
        QuestionList.questions = newquestions;
    }

    public void addQuestion(Question question){
        questions.add(question) ;
    }

    public Question find(int id){
        for (Question ques: questions){
            if(ques.getId()==id){
                return ques ;
            }
        }
        return null ;
    }

    public void remove(int id){
        Question ques = this.find(id) ;
        questions.remove(ques) ;
    }
}
