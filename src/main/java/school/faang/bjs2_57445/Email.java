package school.faang.bjs2_57445;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Setter
@Getter
public class Email {
    private String subject;
    private String body;
    private boolean isImportant;

    public Email(@NonNull String subject, @NonNull String body, @NonNull boolean isImportant) {
        this.subject = subject;
        this.body = body;
        this.isImportant = isImportant;
    }
}
