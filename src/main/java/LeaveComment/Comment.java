package LeaveComment;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class Comment {
    private String name;
    private String comment;
    private LocalDateTime dateTime;

    public Comment(String name, String comment) {
        this.name = name;
        this.comment = comment;
        this.dateTime = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "Comment " + name +
                ": " + comment;
    }
}