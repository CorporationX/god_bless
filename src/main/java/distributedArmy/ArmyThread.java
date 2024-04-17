package distributedArmy;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class ArmyThread extends Thread{
    private final Character character;
    private int totalPower;

    @Override
    public void run() {
        this.totalPower = character.getPower() * character.getAmount();
    }
}
