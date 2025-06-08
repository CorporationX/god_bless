package school.faang.events;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author Danil Pudovkin
 * @since 08.06.2025
 */
@Getter
@RequiredArgsConstructor
public enum SpellEventType {
    CHARM("Чар", "Накладывает чары"),
    TRANSFIGURATION("Трансфигурация", "Преобразует предмет 1"),
    DEFENSE("Защита", "Защищает от атак");

    private final String value;
    private final String description;

    private static final Set<String> VALUES_SET = Arrays.stream(values())
            .map(SpellEventType::getValue)
            .collect(Collectors.toUnmodifiableSet());

    public static Set<String> getValuesSet() {
        return VALUES_SET;
    }
}
