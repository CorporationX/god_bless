package school.faang.task_50072;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public enum Status {
    NEW("New"),
    PROCESSED("Processed");

    private String title;
}
