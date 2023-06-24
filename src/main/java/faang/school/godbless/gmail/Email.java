package faang.school.godbless.gmail;

import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Email {
    public String subject;
    public String body;
    public Boolean isImportant;

    public boolean isImportant() {
        return isImportant;
    }
}
