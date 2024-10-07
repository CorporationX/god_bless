package school.faang.meta.universe;

import lombok.Getter;

import java.util.Set;

@Getter
public class Filter {
    private final String type;
    private final Set<String> triggerWords;

    public Filter(String type, Set<String> triggerWords) {
        if (type == null || type.isEmpty()) {
            throw new IllegalArgumentException("type не может быть пустым");
        }

        this.type = type;
        this.triggerWords = triggerWords;
    }
}
