package school.faang.error;

public class SomeService {

    public static final ServiceResponse DEFAULT_RESPONSE = new ServiceResponse("Ответ=заглушка");

    public ServiceResponse call(String request) {
        if (request.isEmpty()) {
            throw new RuntimeException("Сервис не смог обработать запрос");
        }
        return new ServiceResponse(request);
    }
}