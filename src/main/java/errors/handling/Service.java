package errors.handling;

public class Service {
    public String call(String param) {

        if (param.equals("123")) {
            return "123";
        } else {
            throw new IllegalArgumentException("DEFAULT");
        }
    }
}
