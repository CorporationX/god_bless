package bjs262572;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
@ToString
public class Comment {
    private String text;
    private String author;
    private LocalDateTime timeStamp;
}
