package school.faang.exceptionhandler;

public class RemoteService {

    public String call(String param) throws Exception {
        throw new Exception("Сервис недоступен");
    }
}
