package faang.school.godbless.greatexception;

public class RemoteService {
    public String call(int param) {
        if (param == 1) {
            return "one";
        } else if (param == 2) {
            return null;
        } else {
            return "DEFAULT";
        }
    }
}
