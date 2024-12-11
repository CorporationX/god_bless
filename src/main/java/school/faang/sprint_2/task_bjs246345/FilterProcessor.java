package school.faang.sprint_2.task_bjs246345;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.StackWalker.StackFrame;
import java.util.Optional;
import java.util.function.UnaryOperator;

public class FilterProcessor {
    private final Logger log = LoggerFactory.getLogger(FilterProcessor.class);

    public Image applyFilter(Image image, UnaryOperator<Image> filter) {
        checkValidInput(image, filter);
        return filter.apply(image);
    }

    public UnaryOperator<Image> combineFilters(
            UnaryOperator<Image> firstFilter, UnaryOperator<Image> secondFilter) {
        checkValidInput(firstFilter, secondFilter);
        return image -> firstFilter.andThen(secondFilter).apply(image);
    }

    private <T, U> void checkValidInput(T first, U second) {
        if (first == null || second == null) {
            Optional<StackFrame> frameOptional = StackWalker.getInstance()
                    .walk(frames -> frames
                            .skip(2)
                            .findFirst());

            String callingMethod;
            if (frameOptional.isPresent()) {
                StackFrame frame = frameOptional.get();
                callingMethod = "Class: " + frame.getClassName()
                        + " method: " + frame.getMethodName()
                        + " line " + frame.getLineNumber();
                log.warn("Null input in method {}", callingMethod);
            } else {
                callingMethod = "Unknown method";
                log.warn("Unable to get calling method");
            }

            throw new IllegalArgumentException("Input in " + callingMethod + " cannot be null");
        }
    }
}
