package school.faang.error;

public class Main {

  public static void main(String[] args) {

    String result = ErrorHandler.withErrorHandling(() -> RemoteService.call("service 1"),
        e -> {
          System.out.println("Error with service call, return default response");
          return "DEFAULT";
        });

    System.out.println(result);
  }

  public static class RemoteService {

    public static String call(String serviceName) throws Exception {
      throw new Exception(serviceName + " is not available");
    }
  }
}
