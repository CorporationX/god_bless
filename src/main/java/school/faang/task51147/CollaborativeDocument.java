package school.faang.task51147;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

@Getter
@Slf4j
public class CollaborativeDocument {
    private final Map<String, String> sections = new ConcurrentHashMap<>();

    private void validateString(String... args) {
        Objects.requireNonNull(args);
        Arrays.stream(args).forEach(Objects::requireNonNull);
    }

    public void addData(String sectionId, String data) {
        validateString(sectionId, data);

        sections.put(sectionId, data);
    }

    public String getData(String sectionId) {
        validateString(sectionId);

        if (!sections.containsKey(sectionId)) {
            throw new IllegalArgumentException(String.format("Отсутствует секция с таким id %s", sectionId));
        }
        return sections.get(sectionId);
    }
}
