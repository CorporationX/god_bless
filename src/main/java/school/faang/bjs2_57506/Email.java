package school.faang.bjs2_57506;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Email {

    private String subject;
    private String body;
    private boolean isImportant;

}
