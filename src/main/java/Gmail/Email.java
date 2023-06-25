package Gmail;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Value;

@Data
@AllArgsConstructor
public class Email {
    private String subject;
    private String body;
    private Boolean isImportant;


}
