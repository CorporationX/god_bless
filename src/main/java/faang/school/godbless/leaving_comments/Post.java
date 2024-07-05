package faang.school.godbless.leaving_comments;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
import java.util.Objects;

@Getter
@Setter
@ToString
public class Post {
    public static int postsCounter = 0;

    private int id;
    private String title;
    private String message;
    private String author;
    private List<Comment> commentList;


    public Post(int id, String title, String message, String author, List<Comment> commentList) {
        this.id = id;
        this.title = title;
        this.message = message;
        this.author = author;
        this.commentList = commentList;
        postsCounter++;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof Post post)) return false;

        if (getId() != post.getId()) return false;
        if (getTitle() != null ? !getTitle().equals(post.getTitle()) : post.getTitle() != null) return false;
        if (getMessage() != null ? !getMessage().equals(post.getMessage()) : post.getMessage() != null) return false;
        return getAuthor() != null ? getAuthor().equals(post.getAuthor()) : post.getAuthor() == null;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, message, author);
    }
}
