package school.faang.bjs2_75935;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.Function;
import java.util.function.Predicate;

@Getter
@ToString
public class Post {
    public static final String TITLE_IS_EMPTY = "Post title is empty";
    public static final String CONTENT_IS_EMPTY = "Content is empty";
    public static final String AUTHOR_IS_EMPTY = "Author is empty";

    private final int id; //уникальный идентификатор поста
    private final String title; //заголовок поста
    private final String content; //текст поста
    private final Author author; //автор поста
    //список комментариев (List<Comment>)
    private final List<Comment> comments = Collections.synchronizedList(new ArrayList<>());

    public Post(int id, String title, String content, Author author) {
        new ParamValidator()
            .addParam(Utils.VALIDATE_TEXT.test(title), TITLE_IS_EMPTY)
            .addParam(Utils.VALIDATE_TEXT.test(content), CONTENT_IS_EMPTY)
            .addParam(Utils.VALIDATE_OBJECT.test(author), AUTHOR_IS_EMPTY)
            .validate();

        this.id = id;
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void addComment(Comment comment) {
        comments.add(comment);
    }

    public List<Comment> getComments() {
        return new ArrayList<>(comments);
    }

    public void deleteComment(Comment comment) {
        comments.remove(comment);
    }
}
