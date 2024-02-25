package faang.school.godbless.magicheroes;

import java.util.ArrayList;
import java.util.List;

public class Army {
    private final List<Unit> units;
    private int totalPower;

    public Army(List<Unit> units){
        this.units = units;
        totalPower = 0;
    }

    public int calculateTotalPower(){
        List<TotalPowerThread> threads = new ArrayList<>();
        for (int i=0; i<units.size(); i++){
            threads.add(new TotalPowerThread(units.get(i)));
            threads.get(i).start();
        }

        for (int i = 0; i < threads.size(); i++) {
            try {
                threads.get(i).join();
                totalPower += units.get(i).getPower();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return totalPower;
    }
}
