package school.faang.functional_interfaces__lambdas.bjs2_87464;

public class RemoteService {
    public static String call(String param) {
        if (param.equals("element1")) {
            throw new RuntimeException("Сервис недоступен");
        }
        if (param.equals("element2")) {
            throw new RuntimeException("Канал связи недоступен");
        }
        return "Соединение установлено";
    }
}
