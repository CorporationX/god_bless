package school.faang.sprint2.task46400;

import school.faang.sprint2.task46400.service.RemoteService;

public class Main {
    public static void main(String[] args) {

        // Пример с вызовом удалённого сервиса
        String network_result = ExceptionHandler.withErrorHandling(
                () -> RemoteService.network_call("HandShake"),
                e -> {
                    System.out.println("Ошибка при вызове сервиса network_call");
                    return e.toString();
                }
        );
        System.out.println(network_result);  // Выведет результат: "DEFAULT" при ошибке

        String wifi_result = ExceptionHandler.withErrorHandling(
                () -> RemoteService.wifi_call("HandShake"),
                e -> {
                    System.out.println("Ошибка при вызове сервиса wifi_call");
                    return e.toString();
                }
        );
        System.out.println(wifi_result);
    }


}
