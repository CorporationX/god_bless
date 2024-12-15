package school.faang.task_47107.exception;

import lombok.Getter;

import java.util.List;

@Getter
public class CheckException extends RuntimeException {
    public CheckException(String fieldName) {
        super(String.format("%s не может быть пустым", fieldName));
    }

    public CheckException(String errorMessage, List<String> fieldList) {
        super(String.format(errorMessage, String.join(", ", fieldList)));
    }
}
