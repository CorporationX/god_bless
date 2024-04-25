package faang.school.godbless.concurrency.comment;


import java.util.List;

public record Post(String header, String body, String author, List<Comment> comments) {
}
