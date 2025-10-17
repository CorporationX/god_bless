package school.faang.bjs2_93607;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Objects;

@AllArgsConstructor
@Getter
@ToString
@Slf4j
public class Post {
    private final int id;
    private final String title;
    private final String text;
    private final Author author;
    private final List<Comment> comments;

    public void addComments(Comment comment) {
        comments.add(comment);
    }

    public void removeComments(List<Comment> comments, Author author) {
        if (Objects.nonNull(comments)) {
            comments.removeAll(comments);
        } else {
            log.info("Список комментариев от автора {}, на удаление пуст",
                    author);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Post post = (Post) o;
        return id == post.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
