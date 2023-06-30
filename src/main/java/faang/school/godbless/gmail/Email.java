package main.java.faang.school.godbless.gmail;

import lombok.Value;

@Value
public class Email {
    String subject;
    String body;
    boolean isImportant;
}
