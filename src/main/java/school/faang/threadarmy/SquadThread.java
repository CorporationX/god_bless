package school.faang.threadarmy;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class SquadThread extends Thread {
    private final Squad squad;
    private int squadPower;

    @Override
    public void run() {
        squadPower = squad.calculateSquadPower();
    }
}
