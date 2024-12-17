package school.faang.task_48194;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum City {
    NOVIGRAD(Config.NOVIGRAD_LOCATION),
    OXENFURT(Config.OXENFURT_LOCATION),
    VIZIMA(Config.VIZIMA_LOCATION),
    KAER_MORHEN(Config.KAER_MORHEN_LOCATION);

    private final Location location;
}
