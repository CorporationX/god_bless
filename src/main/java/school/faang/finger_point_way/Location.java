package school.faang.finger_point_way;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Location {
    private final double xxVal; //не самое классное имя, но почему-то checkstyle требует '^[a-z][a-z0-9][a-zA-Z0-9]*$'
    private final double yyVal;
}
