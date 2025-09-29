package bjs2_93615;

import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
class Post {
    private final int id;
    private final String title;
    private final String content;
    private final String author;
    private final List<Comment> comments = new ArrayList<>();

    @Override
    public String toString() {
        return String.format("Пост #%d автора %s: %s\n%s\nКомментарии: %s",
                id, author, title, content, comments);
    }
}