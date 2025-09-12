package school.faang.bjs2_87507;

public class Main {
    public static void main(String[] args) {
        String resultOfCall = ErrorHandler.withErrorHandling(() -> RemoteService.call(2), (e) -> {
            System.out.println("Удалённый сервис сейчас не доступен!");
            return "DEFAULT";
        });
        System.out.println(resultOfCall);
    }
}