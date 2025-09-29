package school.faang.bjs2_91490.army;

import lombok.Getter;

@Getter
class SquadPowerThread extends Thread {
    private final Squad<?> squad;
    private int squadPower;

    public SquadPowerThread(Squad<?> squad) {
        this.squad = squad;
    }

    @Override
    public void run() {
        squadPower = squad.calculateSquadPower();
        System.out.printf("Сила отряда %s: %d%n", squad.name(), squadPower);
    }
}