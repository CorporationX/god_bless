package school.faang.gmail_filte_bjs2_87325;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString

public class Email {
    private String subject;
    private String body;
    private boolean isImportant;

}
