package school.faang.bjs2_91457;

import lombok.Getter;

@Getter
public class SquadThread extends Thread {
    private final Squad squad;
    private int result;

    public SquadThread(Squad squad) {
        this.squad = squad;
    }

    @Override
    public void run() {
        result = squad.calculateSquadPower();
    }
}
