package school.faang.errorHandling;

@FunctionalInterface
public interface MainActionI <T>{
    T get() throws Exception;
}
