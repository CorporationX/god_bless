package school.faang.BJS2_87262;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
public class Email {
    private String subject;
    @Setter
    private String body;
    private Boolean isImportant;

}