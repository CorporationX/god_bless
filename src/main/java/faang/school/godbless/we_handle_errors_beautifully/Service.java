package faang.school.godbless.we_handle_errors_beautifully;

public class Service {
    private static String name;

    public Service(String name) {
        Service.name = name;
    }

    public static String getName() {
        throw new NullPointerException("hello error");
    }

    public static void setName(String name) {
        Service.name = name;
    }
}
