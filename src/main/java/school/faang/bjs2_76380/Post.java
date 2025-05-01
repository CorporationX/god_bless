package school.faang.bjs2_76380;

import java.util.List;

public record Post(long id,
                   String title,
                   String content,
                   User author,
                   List<Comment> comments) {
}
