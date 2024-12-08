package school.faang.sprint_1.task_45025.exceptions;

public class LoadOverflowException extends RuntimeException {
    public LoadOverflowException(double overflowCount) {
        super("Server load overflow on " + overflowCount);
    }
}
