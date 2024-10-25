package ru.kraiush.BJS2_39206;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class Comment {
    private String text;
    private String author;
    private LocalDateTime timestamp;

    @Override
    public String toString() {
        return "\nAuthor: " + author + "\n" +
                "Text: " + text + "\n" +
                "Posted at: " + timestamp + "\n";
    }
}
