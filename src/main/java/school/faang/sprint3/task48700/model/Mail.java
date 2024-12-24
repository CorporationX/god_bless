package school.faang.sprint3.task48700.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class Mail {
    private final String sendTo;
    private final String sendFrom;
    private final String subject;
    private final String body;
}
