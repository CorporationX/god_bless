package school.faang.gmail;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author Danil Pudovkin
 * @since 09.06.2025
 */
@Data
@AllArgsConstructor
public class Email {
    private String subject;
    private String body;
    private boolean isImportant;
}
