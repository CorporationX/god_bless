package faang.school.godbless.starwarsarena;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class Robot {
    private String name;
    private int attackPower;
    private int defensePower;
}
