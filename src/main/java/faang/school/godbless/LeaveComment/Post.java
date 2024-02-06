package faang.school.godbless.LeaveComment;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class Post {
    private int id;
    private String author;
    private String title;
    private String text;
    private volatile List<Comment> comments;

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", text='" + text + '\'' +
                ", comments=" + comments +
                '}';
    }
}
