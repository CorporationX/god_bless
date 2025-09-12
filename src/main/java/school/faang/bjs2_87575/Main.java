package school.faang.bjs2_87575;

public class Main {
    public static void main(String[] args) {
        String result = ExceptionHandlerManager.withErrorHandling(
                () -> RemoteService.call(""),
                e -> {
                    System.out.println("Возникла ошибка! Читайте доки!");
                    return "default value after error handling";
                }
        );
        System.out.println(result);
    }
}
