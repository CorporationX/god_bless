package school.faang.sprint_2.task_45799;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Email {
    //хотел сделать record, но по условию надо менять body,
    //по этому не придумал как это реализовать, может через StringBuilder?
    private final String subject;
    private String body;
    private final boolean isImportant;
}
