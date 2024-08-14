package faang.school.godbless.gmail;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Email {
    private String subject;
    private String body;
    private boolean isImportant;

    @Override
    public String toString() {
        return subject + "\n" + body;
    }
}
