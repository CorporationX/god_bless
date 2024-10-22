package school.BJS2_39188;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
public class Comment {

    private String text;
    private String author;
    private LocalDate timestamp;

    @Override
    public String toString() {
        return "Comment{" +
                "text='" + text + '\'' +
                ", author='" + author + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}
