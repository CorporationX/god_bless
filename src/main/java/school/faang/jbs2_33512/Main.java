package school.faang.jbs2_33512;

import school.faang.jbs2_33512.service.ErrorHandler;
import school.faang.jbs2_33512.service.RemoteService;

public class Main {
    public static void main(String[] args) {
        RemoteService remoteService = new RemoteService();
        String result = ErrorHandler.withErrorHandling(
                () -> remoteService.call("someParam"),
                e -> {
                    System.out.println("Error when calling the service, we return the default value");
                    return "DEFAULT";
                }
        );
        System.out.println(result);
    }
}
