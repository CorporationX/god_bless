package faang.school.godbless.BJS2_25438;

import java.util.Map;

public record Post(long id, String title, String content, Author author, Map<Long, Comment> comments) {
}
