package school.faang.comment;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class Post {
    private int id;
    private String title;
    private String content;
    private String author;
    private final List<Comment> comments = new ArrayList<>();

    public void addComment(Comment comment) {
        comments.add(comment);
    }

    public void deleteComment(Comment comment) {
        comments.remove(comment);
    }

    @Override
    public String toString() {
        return "Post " + id + " title=" + title + '\n' +
                "content = " + content + '\n' +
                "author = " + author + '\n' +
                "comments:" + comments;
    }
}
