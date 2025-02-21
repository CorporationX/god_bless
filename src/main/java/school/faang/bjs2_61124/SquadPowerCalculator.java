package school.faang.bjs2_61124;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class SquadPowerCalculator extends Thread {
    private final Army army;
    private final Squad squad;

    @Override
    public void run() {
        int squadPower = squad.calculateSquadPower();
        army.addPower(squadPower);

        StringBuilder sb = new StringBuilder(50);
        sb.append(squad.getName())
                .append(" power: ")
                .append(squadPower);
        System.out.println(sb);
    }
}
