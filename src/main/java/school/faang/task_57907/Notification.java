package school.faang.task_57907;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.util.regex.Pattern;

@AllArgsConstructor
@Getter
@Setter
@NonNull
public class Notification {
    public static final Pattern OBSCENE_WORDS_PATTERN = Pattern.compile(
            "\\b(черт|блин|фак)\\b", Pattern.CASE_INSENSITIVE
    );

    private final String signature = "\n\nС уважением,\nкоманда Corporation X.";
    @NonNull
    private final NotificationType type;

    @NonNull
    private String message;
}
