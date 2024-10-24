package school.faang.leavingComments;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@AllArgsConstructor
@Getter
public class Comment {
    private static final int MIN_COMMENTS = 5;
    private static final int MAX_COMMENTS = 15;
    private static final Random random = new Random();
    private final String text;
    private final String author;
    private final LocalDateTime timestamp;

    public String formatComment() {
        return "[" + timestamp + "] " + author + ": " + text;
    }

    public static List<Comment> generateComments() {
        List<Comment> comments = new ArrayList<>();
        for (int i = 0; i < random.nextInt(MIN_COMMENTS, MAX_COMMENTS); i++) {
            Comment comment = new Comment("Comment " + i, "Author " + i, LocalDateTime.now().minusMinutes(random.nextInt(1, 10)));
            comments.add(comment);
        }
        return comments;
    }
}
