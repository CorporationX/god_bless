package school.faang.task_46222;

public class RemoteService {
    public static String call(String param) throws Exception {
        if ((param == null) || (param.isBlank())) {
            throw new IllegalArgumentException("param cannot be null or blank");
        }
        return param.toUpperCase();
    }
}
