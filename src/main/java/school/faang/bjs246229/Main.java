package school.faang.bjs246229;

public class Main {
    public static void main(String[] args) {
        Handler<String> handler = Throwable::toString;

        System.out.println(ErrorHandler.withErrorHandling(() -> sendRequest("body"), handler));
        System.out.println(ErrorHandler.withErrorHandling(() -> sendRequest(""), handler));
    }

    public static String sendRequest(String body) {
        if (body == null || body.isEmpty()) {
            throw new IllegalArgumentException("body is null or empty");
        }
        return "STATUS: 200";
    }
}
