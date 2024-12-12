package school.faang.task_45544.exception;


import lombok.Getter;

@Getter
public class CheckException extends RuntimeException {
    public CheckException(String fieldName) {
        super(String.format("%s не может быть пустым", fieldName));
    }
}
