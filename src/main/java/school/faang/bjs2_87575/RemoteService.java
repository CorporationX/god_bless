package school.faang.bjs2_87575;

public class RemoteService {
    private RemoteService() {
    }

    public static String call(String parameter) {
        if (parameter == null || parameter.isBlank()) {
            throw new IllegalArgumentException("error when calling - parameter is wrong");
        }
        return parameter;
    }
}
