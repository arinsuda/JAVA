package sit.int202.quizjpaprojectnew.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@Entity(name = "questions")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    @Column()
    private String question;

    @OneToMany(mappedBy = "question", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Answer> answers = new ArrayList<>(10);


    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", question='" + question + '\'' +
                ", answers=" + answers +
                '}';
    }

//    public Question(String question){
//        this.question = question;
//    }
    public void addAnswer(Answer answer) {
        answers.add(answer);
    }
}
