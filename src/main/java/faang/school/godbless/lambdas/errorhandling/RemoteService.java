package faang.school.godbless.lambdas.errorhandling;

public class RemoteService {
    public String call() {
        return "Заглушка";
    }

    public String call(Integer i) {
        return "Заглушка + " + i;
    }

    public String callWithException() {
        throw new RuntimeException("Эксеншен");
    }

    public String callWithException(Integer i) {
        return "Эксеншен + " + i;
    }
}