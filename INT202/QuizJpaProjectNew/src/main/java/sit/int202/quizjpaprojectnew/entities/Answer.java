package sit.int202.quizjpaprojectnew.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "answers")
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    @Column
    private String answer;

    @NonNull
    @Column(name = "is_correct")
    private Integer isCorrect;

    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question;

//    public Answer(String number, int i) {
//    }

    @Override
    public String toString() {
        return "Answer{" +
                "id=" + id +
                ", answer='" + answer + '\'' +
                ", isCorrect=" + isCorrect +
                '}';
    }
}
