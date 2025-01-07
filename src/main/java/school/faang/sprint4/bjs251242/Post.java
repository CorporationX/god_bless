package school.faang.sprint4.bjs251242;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@RequiredArgsConstructor
public class Post {
    private final int id;
    private final String title;
    private final String content;
    private final String author;
    private final List<Comment> comments = new ArrayList<>();

    public synchronized void addComment(Comment comment) {
        comments.add(comment);
    }

    public synchronized boolean removeComment(Comment comment) {
        return comments.remove(comment);
    }

    @Override
    public String toString() {
        return "id=" + id + " '" + title + ": " + content + "', — " + author;
    }
}