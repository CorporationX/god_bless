package school.faang.finaly_ok_game_BJS2_36341;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public abstract class PigThread extends Thread {
    private String pigName;
    private String material;
}
