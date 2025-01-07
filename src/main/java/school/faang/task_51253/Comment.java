package school.faang.task_51253;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Comment {
    private String text;
    private String author = "N";
    private LocalDateTime timestamp;

    public Comment(String text) {
        this.text = text;
    }
}
