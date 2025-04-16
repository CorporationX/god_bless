package school.faang.bjs2_70440;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Email {
    private String subject;
    private String body;
    private boolean isImportant;
}
