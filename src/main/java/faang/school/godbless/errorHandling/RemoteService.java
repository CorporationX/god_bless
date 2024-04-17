package faang.school.godbless.errorHandling;

public class RemoteService {
    public static String call(boolean param) throws IllegalArgumentException {
        if (!param) {
            throw new IllegalArgumentException("DEFAULT");
        } else {
            return "Access accepted";
        }
    }
}
