package school.faang.heroes.of.might.and.magic;

import lombok.Getter;

public class PowerThread extends Thread {
    private final Squad squad;
    @Getter
    private int power;

    public PowerThread(Squad squad) {
        this.squad = squad;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(100);
            power = squad.calculateSquadPower();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("PowerThread был прерван: " + e.getMessage());
        }
    }
}
