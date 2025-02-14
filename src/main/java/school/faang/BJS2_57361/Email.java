package school.faang.BJS2_57361;

import lombok.Data;
import lombok.NonNull;

@Data
public class Email {
    @NonNull
    private String subject;
    @NonNull
    private String body;
    private final boolean isImportant;
}
