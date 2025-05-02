package school.faang.game;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class PigThread extends Thread {
    protected String pigName;
    protected String material;
}
