package faang.school.godbless.multithreading.leavecomments;

import java.util.List;

public record Post(String title, String text, String author, List<Comment> comments) {}