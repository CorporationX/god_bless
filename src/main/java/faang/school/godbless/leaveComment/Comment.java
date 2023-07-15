package faang.school.godbless.leaveComment;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Calendar;

@AllArgsConstructor
@Getter
public class Comment {
    private String text;
    private Calendar dateTime;
    private String author;

    @Override
    public String toString() {
        return "Comment{" +
                "text='" + text + '\'' +
                ", dateTime=" + dateTime.getTime() +
                ", author='" + author + '\'' +
                '}';
    }
}
