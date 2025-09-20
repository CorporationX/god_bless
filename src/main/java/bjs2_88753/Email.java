package bjs2_88753;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@AllArgsConstructor
public class Email {
    private final String subject;
    @Setter
    private String body;
    private final boolean isImportant;
}