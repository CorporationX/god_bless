package main.java.faang.school.godbless.gmail;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Email {
    String subject;
    String body;
    boolean isImportant;
}
