package school.faang.bjs2_75935;

import lombok.AllArgsConstructor;
import lombok.Getter;

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
public class Post {
    public static final String TITLE_IS_EMPTY = "Post title is empty";
    public static final String CONTENT_IS_EMPTY = "Content is empty";
    public static final String AUTHOR_IS_EMPTY = "Author is empty";

    private static final Predicate<String> VALIDATE_TEXT = text -> text == null || text.isBlank();
    private static final Predicate<Author> VALIDATE_OBJECT = Objects::isNull;

    private final int id; //уникальный идентификатор поста
    private final String title;//заголовок поста
    private final String content;//текст поста
    private final Author author; //автор поста
    private final List<Comment> comments = new ArrayList<>(); //список комментариев (List<Comment>)

    public Post(int id, String title, String content, Author author) {
        new ParamValidator()
            .addParam(VALIDATE_TEXT.test(title), TITLE_IS_EMPTY)
            .addParam(VALIDATE_TEXT.test(content), CONTENT_IS_EMPTY)
            .addParam(VALIDATE_OBJECT.test(author), AUTHOR_IS_EMPTY)
            .validate();

        this.id = id;
        this.title = title;
        this.content = content;
        this.author = author;
    }
}
