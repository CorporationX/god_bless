package school.faang.bjs2_80234;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@AllArgsConstructor
public class Email {
    private String subject;
    @Setter
    private String body;
    private boolean isImportant;
}
