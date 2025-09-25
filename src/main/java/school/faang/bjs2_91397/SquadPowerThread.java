package school.faang.bjs2_91397;

import lombok.Getter;

@Getter
public class SquadPowerThread extends Thread {
    private final Squad<? extends Fighter> squad;
    private int result;

    public SquadPowerThread(Squad<? extends Fighter> squad) {
        if (squad == null) {
            throw new IllegalArgumentException("Не может быть нулевым или незаполненным");
        }
        this.squad = squad;
    }

    @Override
    public void run() {
        result = squad.calculateSquadPower();
    }
}
