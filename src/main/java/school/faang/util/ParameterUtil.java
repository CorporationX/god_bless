package school.faang.util;

public class ParameterUtil {
    public static void checkStringArg(String arg, String argName) {
        if (arg == null || argName.isBlank()) {
            throw new IllegalArgumentException(argName + " can not to be null or empty");
        }
    }
}
