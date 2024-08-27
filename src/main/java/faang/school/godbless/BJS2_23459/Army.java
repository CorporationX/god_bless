package faang.school.godbless.BJS2_23459;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Army {
    private List<Division> divisions;
    private Map<String, List<Division>> divisionsByTypes = new HashMap<>();

    public Army(List<Division> divisions) {
        this.divisions = divisions;
    }

    public int calculateTotalPower() {
        divideIntoDivisions(divisions);
        CalculatorThread[] threads = new CalculatorThread[divisionsByTypes.size()];
        int index = 0;
        for (var divisionsByType : divisionsByTypes.entrySet()) {
            threads[index] = new CalculatorThread(divisionsByType.getValue());
            threads[index].start();
            index++;
        }
        for (var thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        int totalPower = 0;
        for (var thread : threads) {
            totalPower += thread.getDivisionTotalPower();
        }
        return totalPower;
    }

    private void divideIntoDivisions(List<Division> divisions) {
        for (var division : divisions) {
            divisionsByTypes.computeIfAbsent(division.getClass().getSimpleName(), type -> new ArrayList<>()).add(division);
        }
    }
}
