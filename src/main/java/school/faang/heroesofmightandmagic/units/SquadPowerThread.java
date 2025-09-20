package school.faang.heroesofmightandmagic.units;

import lombok.Getter;

@Getter
public class SquadPowerThread extends Thread {

    private Squad squad;
    private int result;

    public SquadPowerThread(Squad squad) {
        this.squad = squad;
    }

    @Override
    public void run() {
        result = squad.calculateSquadPower();
    }

}
