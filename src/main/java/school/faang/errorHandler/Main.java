package school.faang.errorHandler;

public class Main {
  public static void main(String[] args) {
    String result = ErrorHandler.withErrorHandling(
        () -> RemoteService.call("someParam"),
        e -> {
          System.out.println("Ошибка при вызове сервиса, возвращаем дефолтное значение");
          System.out.println(e.getMessage());
          return "DEFAULT";
        }
    );

    System.out.println(result);
  }

  public static class RemoteService {
    public static String call(String param) throws Exception {
      throw new Exception("Сервис недоступен");
    }
  }
}
