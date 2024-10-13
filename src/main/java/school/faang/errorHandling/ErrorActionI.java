package school.faang.errorHandling;

@FunctionalInterface
public interface ErrorActionI <T>{
    T handleError(Exception e);
}
