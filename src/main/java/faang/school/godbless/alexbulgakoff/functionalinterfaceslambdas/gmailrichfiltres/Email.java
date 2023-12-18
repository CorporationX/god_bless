package faang.school.godbless.alexbulgakoff.functionalinterfaceslambdas.gmailrichfiltres;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author Alexander Bulgakov
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
public class Email {

    private String subject;

    private String body;

    private boolean isImportant;
}
