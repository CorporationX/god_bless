package school.faang.error;

public class Service {
    public static final Response DEFAULT_RESPONSE = new Response(
            "{status: success; redirect:https://site.ru}");

    public Response get(Request request) {
        if (request.body().isEmpty()) {
            throw new IllegalArgumentException("Ошибка запроса");
        }
        return new Response("{status: success}");
    }
}
