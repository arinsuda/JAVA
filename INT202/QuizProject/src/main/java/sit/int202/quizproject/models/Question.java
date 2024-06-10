package sit.int202.quizproject.models;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Question {
    private static int count = 0;
    private int id ;
    private String question ;
    private ArrayList<Answer> answers ;

    public Question(String question) {
        this.id = ++count ;
        this.question = question;
        this.answers = new ArrayList<>(5) ;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public ArrayList<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(ArrayList<Answer> answers) {
        this.answers = answers;
    }

    public void addAnswer(Answer answer){
        this.answers.add(answer) ;
    }

    public void addAnswer(String answer){
        Answer ans = new Answer(answer) ;
        this.answers.add(ans) ;
    }

    public void addAnswer(String answer, boolean isCorrect){
        Answer ans = new Answer(answer,isCorrect) ;
        this.answers.add(ans) ;
    }

    public String getCorrectAnswer(){
        for(Answer answer: answers){
            if(answer.isCorrect()){
                return answer.getAnswer() ;
            }
        }
        return "No Correct" ;
    }

    public int getCorrectIndex(){
        int index = -1;
        for(int i = 0; i<answers.size();i++){
            if(answers.get(i).isCorrect()){
                index = i;
                return index;
            }
        }
        return index;
    }

    public void remove(String answer){
        Answer ans = this.find(answer);
        if(ans != null){
            answers.remove(ans);
        }
    }
    public Answer find(String answer){
        for(Answer ans : answers){
            if(ans.getAnswer().equals(answer)){
                return ans;
            }
        }
        return null;
    }
    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", question='" + question + '\'' +
                ", answers=" + answers +
                '}';
    }
}
