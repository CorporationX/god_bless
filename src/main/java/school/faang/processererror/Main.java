package school.faang.processererror;

public class Main {
    public static void main(String[] args) {
        String result = RemoteService.withErrorHandling(
                () -> RemoteService.call("someParam"),
                e -> {
                    System.out.println("Ошибка при вызове сервиса, возвращаем дефолтное значение");
                    return "DEFAULT";
                }
        );

        System.out.println(result);
    }
}
