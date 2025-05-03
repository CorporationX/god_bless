package school.faang.leavecomment;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@AllArgsConstructor
@Getter
public class Post {
    private final int id;
    private final String author;
    private final Map<Integer, Comment> commentsById = new ConcurrentHashMap<>();
    private String title;
    private String content;

    public void addComment(Comment comment) {
        commentsById.put(comment.getId(), comment);
    }

    public void removeComment(int commentId) {
        commentsById.remove(commentId);
    }

    @Override
    public String toString() {

        return String.format(
                "\nPost id: %d\nPost Author: %s\nPost title: %s\nPost content: %s\n",
                id, author, title, content
        );
    }
}
