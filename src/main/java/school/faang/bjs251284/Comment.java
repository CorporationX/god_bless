package school.faang.bjs251284;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;

@Getter
@Slf4j
public class Comment {

    private final String text;
    private final String author;
    private final LocalDateTime timeStamp;

    public Comment(String text, String author) {
        if (text == null || text.isEmpty()) {
            log.error("Text cannot be null or empty");
            throw new IllegalArgumentException("Text cannot be null or empty");
        }
        if (author == null || author.isEmpty()) {
            log.error("Author cannot be null or empty");
            throw new IllegalArgumentException("Author cannot be null or empty");
        }
        this.text = text;
        this.author = author;
        this.timeStamp = LocalDateTime.now();
        log.info("Comment created by {} at {}", author, timeStamp);
    }
}


