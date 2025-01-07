package school.faang.sprint4.bjs251242;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
@RequiredArgsConstructor
public class Comment {
    private final String text;
    private final String author;
    private final LocalDateTime timestamp = LocalDateTime.now();

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss dd.MM.yyyy");
        return "[" + timestamp.format(formatter) + "] " + text + ", — " + author;
    }
}