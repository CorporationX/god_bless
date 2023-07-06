package faang.school.godbless.sprint5.multithreading_conc.task1_comment;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public class Comment {

    private String comment;

    private LocalDateTime data;

    private String author;

    @Override
    public String toString() {
        return "comment='" + comment + '\'' +
                ", data=" + data +
                ", author='" + author + '\'';
    }
}
