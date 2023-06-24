package faang.school.godbless.handle_nicely;

public class RemoteService {
    public void call(String string) {
        if (string == null || string.isBlank()) {
            throw new IllegalArgumentException("Не удалось получить доступ к Remote Service");
        }
        System.out.println("call received: the question is " + string);
    }

    public static void main(String[] args) {
        RemoteService remoteService = new RemoteService();
        remoteService.call("");
    }
}
