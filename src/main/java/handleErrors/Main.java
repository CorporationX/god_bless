package handleErrors;

import java.util.List;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {

        String normal = ErrorsManager.withErrorHandling(() -> {
            RemoteService remoteService = new RemoteService();
            return remoteService.call(222);
        }, (exception -> "DEFAULT"));
        System.out.println(normal);

        String exception = ErrorsManager.withErrorHandling(() -> {
            RemoteService remoteService = new RemoteService();
            int[] nums = {1, 2, 3};
            return remoteService.call(nums[4]);
        }, (exception1 -> "DEFAULT"));
        System.out.println(exception);
    }
}
