package school.faang.gmailRichFilterg80060;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
@Setter
public class Email {
    private String subject;
    private String body;
    private boolean important;

}
