package faang.school.godbless.exception;

public class RemoteService {
    public String call(String string) {
        if (string == null || string.isBlank()) {
            throw new IllegalArgumentException("Не удалось получить доступ к Remote Service");
        }

        return "call received: the question is " + string;
    }
}
