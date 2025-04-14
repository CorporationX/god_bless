package school.faang.bjs2_68795.amazon_warehouse;

public class MessageFormatter {
    public static String format(String template, Object... args) {
        for (Object arg : args) {
            template = template.replaceFirst("\\{}", arg == null ? "null" : arg.toString());
        }
        return template;
    }
}
