package school.faang.task_57236;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class Email {
    private String subject; //тема письма;

    private String body;
    private boolean isImportant; //флаг, указывающий, важное письмо или нет.
}
