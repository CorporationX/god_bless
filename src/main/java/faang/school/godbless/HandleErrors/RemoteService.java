package faang.school.godbless.HandleErrors;

public class RemoteService {
    public static <T> T withErrorHandling(OperationCall<T> call, ExceptionHandler<T> handler) {
        try {
            return call.call();
        } catch (Exception e) {
            return handler.handle(e);
        }
    }
}
