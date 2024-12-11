package school.faang.task_45822;

import lombok.Getter;
import lombok.NonNull;

@Getter
public final class Email {
    private final @NonNull String subject;
    private @NonNull String body;
    private final boolean isImportant;

    public Email(@NonNull String subject, @NonNull String body, boolean isImportant) {
        this.subject = subject;
        this.body = body;
        this.isImportant = isImportant;
    }

    public void setBody(@NonNull String body) {
        this.body = body;
    }

}
