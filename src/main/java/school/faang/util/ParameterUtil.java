package school.faang.util;

public class ParameterUtil {
    public static void checkStringArg(String arg, String argName) {
        if (arg == null || arg.isBlank()) {
            throw new IllegalArgumentException(argName + " can not to be null or empty");
        }
    }
}
