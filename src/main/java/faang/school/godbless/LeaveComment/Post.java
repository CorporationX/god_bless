package faang.school.godbless.LeaveComment;

import java.util.List;

public record Post(int id, String title, String author, List<Comment> comments) {
}
