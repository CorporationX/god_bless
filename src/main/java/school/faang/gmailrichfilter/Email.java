package school.faang.gmailrichfilter;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class Email {
    private String subject;
    private String body;
    boolean important;
}
