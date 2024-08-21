package pigs.game.players;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PigThread extends Thread {
    protected final String pigName;
    protected final String material;

    @Override
    public void run() {
        System.out.printf("%s starting to build his house from %s%n", this.pigName, this.material);
    }
}
