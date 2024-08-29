package faang.school.godbless.comment;

import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@ToString
public class Post {
    private static int counterId = 0;

    private final int id;
    private final String title;
    private final String text;
    private final Author author;
    private final List<Comment> comments;

    public Post(@NonNull String title, String text, @NonNull Author author) {
        if (title.isBlank()) {
            throw new IllegalArgumentException("Title couldn't be empty");
        }

        this.id = counterId++;
        this.title = title;
        this.text = text;
        this.author = author;
        this.comments = new ArrayList<>();
    }

    public void addComment(Comment comment) {
        synchronized (this) {
            comments.add(comment);
        }
    }
}
