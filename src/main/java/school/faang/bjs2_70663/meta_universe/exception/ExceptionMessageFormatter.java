package school.faang.bjs2_70663.meta_universe.exception;

public class ExceptionMessageFormatter {
    public static String format(String template, Object... args) {
        for (Object arg : args) {
            template = template.replaceFirst("\\{}", arg == null ? "null" : arg.toString());
        }
        return template;
    }
}
