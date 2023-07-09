package faang.school.godbless.sprint3Java8FunctionalInterfacesAndLambdas.task6;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Email {
    private String subject;
    private String body;
    private boolean isImportant;
}
