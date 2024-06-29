package faang.school.godbless.concur1;

import java.util.ArrayList;
import java.util.List;

public record Post(int id, String title, String text, String author, List<Comment> comments) {
    public Post(int id, String title, String text, String author) {
        this(id, title, text, author, new ArrayList<>());
    }
}
