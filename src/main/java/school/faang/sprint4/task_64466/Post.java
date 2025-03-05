package school.faang.sprint4.task_64466;

import java.util.List;

public record Post(int id, String title, String content, String author, List<Comment> comments) {
}

