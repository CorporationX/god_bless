package faang.school.godbless.leave_a_comment;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Comment {
    private static int startId = 0;
    private int id;
    private String content;
    private LocalDateTime localDateTime;
    private User author;
    private int postId;

    public Comment(String content, User author, int postId) {
        this.id = startId++;
        this.content = content;
        this.localDateTime = LocalDateTime.now();
        this.author = author;
        this.postId = postId;
    }
}