package school.faang.m1s2.bjs2_33546_gmail;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Email {
    private String subject;
    private String body;
    private final boolean isImportant;
}
