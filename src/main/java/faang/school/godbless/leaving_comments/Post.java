package faang.school.godbless.leaving_comments;

import java.util.List;
import java.util.Objects;

public record Post(int id, String title, String message, String author, List<Comment> commentList) {
    public static int postsCounter = 0;

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

        if (id() != post.id()) return false;
        if (title() != null ? !title().equals(post.title()) : post.title() != null) return false;
        if (message() != null ? !message().equals(post.message()) : post.message() != null) return false;
        return author() != null ? author().equals(post.author()) : post.author() == null;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, message, author);
    }
}
