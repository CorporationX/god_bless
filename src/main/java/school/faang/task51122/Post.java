package school.faang.task51122;

import java.util.List;

public record Post(int id,
                   String title,
                   String content,
                   Author author,
                   List<Comment> comments) {
}
