package school.faang.leave.comments;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record Comment(int id, String text, String author, LocalDateTime timestamp) {

    public boolean isCommentAuthor (String user) {
        return author.equals(user);
    }

    @Override
    public String toString() {
        return author + " " + timestamp + " " + text;
    }
}
