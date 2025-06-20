package school.faang.diary;

/**
 * @author Danil Pudovkin
 * @since 20.06.2025
 */
public class CourseNotFoundException extends RuntimeException {
    public CourseNotFoundException() {
        super("Course not found");
    }
}
