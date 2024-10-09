package school.faang.handlingErrors;

public class MockService {
    public String call(String param) throws Exception {
        if (param != null) {
            throw new Exception("You can't call service with a string parameter!");
        } else {
            throw new Exception("You can't call service with a null parameter!");
        }
    }
}
