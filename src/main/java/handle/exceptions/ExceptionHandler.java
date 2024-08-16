package handle.exceptions;

public interface ExceptionHandler <T>{
    T handle(Exception e);
}
