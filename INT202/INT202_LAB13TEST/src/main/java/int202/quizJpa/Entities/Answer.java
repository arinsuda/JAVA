package int202.quizJpa.Entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@Table(name = "answers")
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    @Column(name = "answer", length = 100)
    private String answer;

    @NonNull
    @Column(name = "is_correct")
    private Integer isCorrect;

    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question;

    @Override
    public String toString() {
        return "Answer{" +
                "id=" + id +
                ", answer='" + answer + '\'' +
                ", isCorrect=" + isCorrect +
                ", question=" + question +
                '}';
    }
}
