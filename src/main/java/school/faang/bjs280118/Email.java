package school.faang.bjs280118;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class Email {
    private String subject;
    private String body;
    private Boolean isImportant;

    public boolean isImportant() {
        return isImportant;
    }
}
