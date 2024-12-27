package school.faang.sprint_4.task_51901;

import java.util.List;

public record Post(int id, String title, String content, String author, List<Comment> comments) {
}
