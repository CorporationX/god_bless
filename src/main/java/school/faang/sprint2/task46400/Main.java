package school.faang.sprint2.task46400;

import school.faang.sprint2.task46400.service.RemoteService;

public class Main {
    public static void main(String[] args) {


        // Пример с вызовом удалённого сервиса
        String networkResult = ExceptionHandler.withErrorHandling(
                () -> RemoteService.networkCall("HandShake"),
                e -> {
                    System.out.println("Ошибка при вызове сервиса networkCall: " + e.toString());
                    return "DEFAULT";
                }
        );
        System.out.println(networkResult);

        String wifiResult = ExceptionHandler.withErrorHandling(
                () -> RemoteService.wifiCall("HandShake"),
                e -> {
                    System.out.println("Ошибка при вызове сервиса wifiCall: " + e.toString());
                    return "DEFAULT";
                }
        );
        System.out.println(wifiResult);
    }
}