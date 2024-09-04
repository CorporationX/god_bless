package leave.comments;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
public class Comment {
    private final String text;
    private final LocalDateTime createdAt;
    private final Author author;

    public void showComment() {
        System.out.printf(
            "Автор комментария: %s\nСодержимое: %s\nДата создания: %s\n",
            this.getAuthor().getName(),
            this.getText(),
            this.getCreatedAt()
        );
    }
}
