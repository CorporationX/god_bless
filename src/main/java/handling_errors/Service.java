package handling_errors;

public class Service {
    public String call(String param) {
        if (!param.equals("123")) {
            return param;
        }
        throw new IllegalArgumentException("ошибка");
    }
}
