package school.faang.sprint_2.processing_exceptions;

@FunctionalInterface
public interface ServiceCallException {
    String returnDefault(Exception e);
}
