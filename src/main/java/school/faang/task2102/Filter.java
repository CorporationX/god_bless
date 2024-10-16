package school.faang.task2102;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Filter {
    private static final String[] FORBIDDEN_WORDS = {"shit", "niger"};
    private static final String FORBIDDEN_WORD_REGEX = "(?i)%s";
    private static final String SENSITIVE_INFO_REGEX = "(?i)password: \\S+";

    private static final Map<FilterType, Function<String, String>> filterTypeFunctionMap = Map.of(
            FilterType.FORBIDDEN, Filter::obscureForbiddenWords,
            FilterType.SENSITIVE, Filter::obscureSensitiveInfo
    );

    public static Notification filterMessageContent(Notification notification, List<FilterType> filterTypes) {
        List<Function<String, String>> filtersToApply = extractFilterFunctions(filterTypes);

        String sanitizedMessage = filtersToApply.stream()
                .reduce(Function.identity(), Function::andThen)
                .apply(notification.message());

        return new Notification(notification.type(), sanitizedMessage);
    }

    private static List<Function<String, String>> extractFilterFunctions(List<FilterType> filterTypes) {
        return filterTypes.stream()
                .map(filterTypeFunctionMap::get)
                .collect(Collectors.toList());
    }

    //TODO Для закомментированного кода IDEA выдает предупреждение для result - "Reassigned local variable".
    // Стоит ли тут что-то с этим делать и зачем?
    // Чтобы не ругалась, переписал на Stream API и lambda
    private static String obscureForbiddenWords(String message) {
//        String result = message;
//        for (String word : FORBIDDEN_WORDS) {
//            result = message.replaceAll(String.format(FORBIDDEN_WORD_REGEX, word), "***");
//        }
//        return result;

        return Arrays.stream(FORBIDDEN_WORDS)
                .reduce(message, (result, word) -> result.replaceAll(String.format(FORBIDDEN_WORD_REGEX, word), "***"));
    }

    private static String obscureSensitiveInfo(String message) {
        return message.replaceAll(SENSITIVE_INFO_REGEX, "password: ***");
    }
}