package BJS2_9315;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
public class Email {
    private String subject;
    private String body;
    private boolean isImportant;
}