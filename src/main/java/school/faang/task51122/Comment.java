package school.faang.task51122;

import java.time.LocalDateTime;

public record Comment(String text,
                      Author author,
                      LocalDateTime time) {

}