package school.faang.sprint_2.task_46162;

public class RemoteService {
    public String callWithException(String param) throws Exception {
        throw new Exception("Сервис недоступен");
    }

    public String successCall(String param) {
        System.out.println("Сервис успешно ответил");
        return "some data with param: " + param;
    }
}
