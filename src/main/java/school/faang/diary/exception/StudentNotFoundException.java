package school.faang.diary.exception;

/**
 * @author Danil Pudovkin
 * @since 20.06.2025
 */
public class StudentNotFoundException extends RuntimeException {
    public StudentNotFoundException() {
        super("Student not found");
    }
}
