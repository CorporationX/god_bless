package faang.school.godbless.commenting3243;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
@AllArgsConstructor
public class Comment {
    private static final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MM-dd-yyyy HH:mm:ss");
    private String text;
    private LocalDateTime time;
    private String author;

    @Override
    public String toString() {
        return String.format("""
                %s
                %s | %s
                """,
                this.getText(),
                this.getAuthor(),
                this.getTime().format(dateFormatter));
    }
}
