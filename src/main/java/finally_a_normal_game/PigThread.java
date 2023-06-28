package finally_a_normal_game;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class PigThread extends Thread{
    private String pigName;
    private String material;
}
