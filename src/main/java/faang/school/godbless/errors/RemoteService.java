package faang.school.godbless.errors;

import java.util.function.Supplier;
public class RemoteService {
    public static void main(String[] args) {
        String result = withErrorHandling(() -> {
                    try {
                        return remoteServiceCall("param");
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                },
                e -> { System.err.println("Failed to access the Remote Service. Return to default value");
                    return "DEFAULT";
                }
        );
        System.out.println(result);
    }

    public static <T> T withErrorHandling(Supplier<T> action, ExceptionHandler<T> onError) {
        try {
            return action.get();
        } catch (Exception e) {
            return onError.handle(e);
        }
    }

    public static String remoteServiceCall(String param) throws Exception {
        throw new Exception("Error in remote service call");
    }
}
