package faang.school.godbless;

public class RemoteService {
    public String call(String string) {
        if (string == null || string.isBlank()) {
            throw new IllegalArgumentException("Нет доступа к Remote Service");
        }
        return "call received: the question is " + string;
    }
}
