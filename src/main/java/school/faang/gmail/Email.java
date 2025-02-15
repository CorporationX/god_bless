package school.faang.gmail;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Set;

@Data
@AllArgsConstructor
public class Email {
    private String subject;
    private String body;
    private boolean isImportant;
    private static final Set<String> SPAM = Set.of("Спам");

    public static Set<String> getSpam() {
        return SPAM;
    }
}
