package school.faang.bjs2_86067;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum City {

    LONDON("London"),
    MADRID("Madrid"),
    PARIS("Paris"),
    BRAZIL("Brazil"),
    SOCHI("Sochi");

    private final String cityName;
}