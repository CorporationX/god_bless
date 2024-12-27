package school.faang.bjs248205;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum City {
    FOVOGRAD(new Location(0.0, 60.0)),
    AXENFURT(new Location(60.5, 30.5)),
    NIKIMA(new Location(120.0, 10.0)),
    GDOAXEN(new Location(150.5, 50.0));

    private final Location location;
}