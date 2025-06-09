package school.faang.bjs2_79928;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class Email {
    private String subject;
    private String body;
    private boolean isImportant;

    public boolean hasContent() {
        return (subject != null && !subject.isBlank())
                && (body != null && !body.isBlank());

    }
}
