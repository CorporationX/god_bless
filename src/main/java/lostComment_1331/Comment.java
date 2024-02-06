package lostComment_1331;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data

public class Comment {
    private String text;
    private LocalTime time;
    private LocalDate date;
    private String author;

    public Comment(String text, String author) {
        this.text = text;
        this.time = LocalTime.now();
        this.date = LocalDate.now();
        this.author = author;
    }
}