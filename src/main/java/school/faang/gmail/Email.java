package school.faang.gmail;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Email {
    @NonNull
    private String subject;
    @NonNull
    private String body;
    @NonNull
    private boolean isImportant;
}