package faang.school.godbless.multithreading.leavecomments;

import java.time.LocalDateTime;

public record Comment(String author, LocalDateTime dateTime, String comment) {}