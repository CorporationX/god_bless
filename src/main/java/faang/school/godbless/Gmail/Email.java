package faang.school.godbless.Gmail;

import lombok.Data;
import lombok.NonNull;

@Data
public class Email {
    @NonNull
    private String subject;
    @NonNull
    private String body;
    @NonNull
    private Boolean isImportant;
}
