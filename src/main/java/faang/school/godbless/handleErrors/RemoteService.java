package faang.school.godbless.handleErrors;

public class RemoteService {
    public String call(int param) throws RuntimeException {
        if (param < 0) {
            throw new RuntimeException();
        } else {
            return "Successful call to remote service";
        }
    }
}
