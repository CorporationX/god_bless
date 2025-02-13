package BJS257630;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {
    public static void main(String[] args) {
        String result = ErrorHandler.withErrorHandling(
                () -> RemoteService.call("primary Action"),
                e -> {
                    System.out.println(" We have any problem ");
                    return "Default";
                }
        );
        System.out.println(result);
    }


    public static class RemoteService {
        public static String call(String param) {
            log.info("call RemoteService");
            throw new RuntimeException("Service not working");
        }
    }
}
