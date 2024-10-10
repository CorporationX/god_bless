package school.faang.error_hending;

public class RemoteService {
    public String call(String param) throws Exception {
        // Здесь возникнет ошибка для демонстрации
//          throw new Exception("Сервис недоступен");
        return "Всё окей, работаемс!;)";
    }
}
