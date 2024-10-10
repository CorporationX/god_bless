package school.faang.error_hending;

public class RemoteService {
    public <T> T call(String param) throws Exception {
        // Здесь возникнет ошибка для демонстрации
          throw new Exception("Сервис недоступен");
//        return (T) "Всё окей, работаемс!;)";
    }
}
