package faang.school.godbless.WeLeaveAComment;

import java.util.List;

public record Post(String headline, String message, String author, List<Comment> comments) { }
