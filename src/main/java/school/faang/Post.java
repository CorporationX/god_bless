package school.faang;

import java.util.List;

public record Post(int id, String title, String content, String author, List<Comment> comments) {
}

