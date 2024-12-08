package school.faang.sprint2.task46400;

import school.faang.sprint2.task46400.service.RemoteService;

public class Main {
    public static void main(String[] args) {

        // Пример с вызовом удалённого сервиса
        String networkResult = ExceptionHandler.withErrorHandling(
                () -> RemoteService.networkCall("HandShake"),
                e -> {
                    System.out.println("Ошибка при вызове сервиса networkCall");
                    return e.toString();
                }
        );
        System.out.println(networkResult);  // Выведет результат: "DEFAULT" при ошибке

        String wifiResult = ExceptionHandler.withErrorHandling(
                () -> RemoteService.wifiCall("HandShake"),
                e -> {
                    System.out.println("Ошибка при вызове сервиса wifiCall");
                    return e.toString();
                }
        );
        System.out.println(wifiResult);
    }


}
