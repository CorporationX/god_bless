package faang.school.godbless.putyourfingeronthepath;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class City {
    private final String name;
    private final Location location;
    private final int distanceFromKaerMorhen;
}