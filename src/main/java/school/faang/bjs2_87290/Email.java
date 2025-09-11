package school.faang.bjs2_87290;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class Email {
    @Getter
    private String subject;
    @Getter
    @Setter
    private String body;
    @Getter
    private boolean isImportant;
}
