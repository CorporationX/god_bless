package faang.school.godbless.gmail_filters;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Email {
    private String subject;
    private String body;
    private Boolean isImportant;

    @Override
    public String toString() {
        return subject + ": "+ body;
    }


}
