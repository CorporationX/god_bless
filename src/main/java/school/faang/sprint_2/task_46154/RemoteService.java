package school.faang.sprint_2.task_46154;

public class RemoteService {

    public static String call(String param) {
        try {
            throw new Exception("Сервис недоступен");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
