package school.faang.task_45544;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ErrorMessage {
    EMPTYFIELD("%s не может быть пустым");

    private final String value;
}
