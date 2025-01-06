package school.faang.task_51103;

import lombok.Getter;
import school.faang.exception.CheckException;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Getter
public class Post {
    private final int id;
    private final String title;
    private final String content;
    private final String author;
    private final List<Comment> comments;

    public Post(int id, String title, String content, String author, List<Comment> comments) {
        if (title == null || title.isEmpty()) {
            throw new CheckException("title");
        }
        if (author == null || author.isEmpty()) {
            throw new CheckException("postAuthor");
        }
        if (comments == null) {
            throw new CheckException("comments");
        }

        this.id = id;
        this.title = title;
        this.content = content;
        this.author = author;
        this.comments = new CopyOnWriteArrayList<>(comments);
    }

    public void addCommentToPost(Comment comment) {
        if (comment == null) {
            throw new CheckException("comment");
        }
        comments.add(comment);
        System.out.printf("Комментарий автора: %s добавлен!%n", comment.getAuthor());
    }

    public void deleteCommentByAuthor(String author) {
        List<Comment> commentsByAuthor = comments.stream()
                .filter(comment -> comment.getAuthor().equals(author))
                .toList();
        if (commentsByAuthor.isEmpty()) {
            System.out.printf("У автора: %s нет комментариев в посте!%n", author);
            return;
        }
        comments.removeAll(commentsByAuthor);
        System.out.printf("Все комментарии автора: %s удалены!%n", author);
    }
}
