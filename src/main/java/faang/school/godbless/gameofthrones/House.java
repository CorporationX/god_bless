package faang.school.godbless.gameofthrones;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;



@Setter
@Getter
@RequiredArgsConstructor
@EqualsAndHashCode
@ToString
public class House {
    private final String name;
    private final String sigil;

}
