package int202.quizJpa.Entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@Table(name = "questions")
@NamedQueries({
        @NamedQuery(name = "Question.SortByQuestion", query = "Select q from Question q order by q.question DESC "),
        @NamedQuery(name = "Question.SearchByQuestion", query = "Select q from Question q where q.question = :param"),
//        @NamedQuery(name = "Question.QuestionsByUserName", query = "Select q from Question q where q.userName = :param"),
})
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    @Column(name = "question", length = 200)
    private String question;

//    @ManyToOne
//    @JoinColumn(name = "username")
//    private User userName;

    @OneToMany(mappedBy = "question", orphanRemoval = true, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Answer> answers = new ArrayList<>(10);

    @Override
    public String toString() {
        return "Questions{" +
                "id=" + id +
                ", question='" + question + '\'' +
                ", answers=" + answers +
                '}';
    }

    public void addAnswer(Answer answer) { answers.add(answer); }
}
