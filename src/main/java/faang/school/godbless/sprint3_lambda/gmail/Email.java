package main.java.faang.school.godbless.sprint3_lambda.gmail;

import lombok.Value;

@Value
public class Email {
    String subject;
    String body;
    boolean isImportant;
}
