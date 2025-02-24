package school.faang.task61254.service;

import java.util.List;

public class Squad {
    private List<Archer> archers = List.of(
            new Archer(),
            new Archer(),
            new Archer()
    );

    private List<Archer> archers = List.of(
            new Archer(),
            new Archer(),
            new Archer()
    );
    private List<Mage> mages;
    private List<Swordsman> swordsmen;

    public int calculateSquadPower() {
        int powerArchers = 0;
        int powerMages = 0;
        int powerSwordsmen = 0;
        int squadPower = 0;
        for (Archer archer : archers) {
            powerArchers += archer.getPOWER();
        }
        for (Mage mage : mages) {
            powerMages += mage.getPOWER();
        }
        for (Swordsman swordsman : swordsmen) {
            powerSwordsmen += swordsman.getPOWER();
        }

        squadPower = powerArchers + powerMages + powerSwordsmen;
        return squadPower;
    }
}
