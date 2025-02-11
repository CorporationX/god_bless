package school.faang.gmail;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class Email {
    @NonNull
    private String subject;
    @NonNull
    private String body;
    @NonNull
    private boolean isImportant;
}