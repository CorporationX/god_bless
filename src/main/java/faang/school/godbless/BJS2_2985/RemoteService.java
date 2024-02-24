package faang.school.godbless.BJS2_2985;

public class RemoteService {

    RemoteService() {
    }

    String call(int param) throws IllegalArgumentException {
        if (param == 0) {
            throw new IllegalArgumentException("Forbidden value");
        } else {
            return "OK";
        }
    }
}
