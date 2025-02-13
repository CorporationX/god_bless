package school.faang.BJS2_57418;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Email {

    private final String subject;
    private String body;
    private final boolean isImportant;

    public Email(@NonNull String subject, @NonNull String body, boolean isImportant) {
        this.subject = subject;
        this.body = body;
        this.isImportant = isImportant;
    }
}
