package faang.school.godbless.BJS2_25347;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;
@Getter
@AllArgsConstructor

public class Comment {
    private int id;
    private String text;
    private LocalDateTime dateTime;
    private Author author;
    private Post post;

    @Override
    public String toString() {
        return id+" "+text+" "+dateTime+" "+author;
    }
}
