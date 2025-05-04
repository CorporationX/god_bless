package school.faang.stream4.facebookleavingacomment;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Getter
public class Comment {
    private final String text;
    private final String author;
    private final LocalDateTime timeStamp;
}
