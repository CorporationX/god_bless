package processing.exceptions;

@FunctionalInterface
public interface ServiceCallException {
    String returnDefault(Exception e);
}
