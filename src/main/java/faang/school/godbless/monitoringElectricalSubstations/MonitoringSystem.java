package faang.school.godbless.monitoringElectricalSubstations;

import java.text.DecimalFormat;
import java.util.concurrent.ConcurrentHashMap;

public class MonitoringSystem {
    private final ConcurrentHashMap<Integer, Double> substationData;
    private final DecimalFormat decimalFormat;

    public MonitoringSystem() {
        this.substationData = new ConcurrentHashMap<>();
        this.decimalFormat = new DecimalFormat("#0.00");
    }

    public void updateData(int substationId, double averageData) {
        substationData.put(substationId, averageData);
        String formattedData = decimalFormat.format(averageData);
        System.out.println("Substation " + substationId + " - Average Data: " + formattedData);
    }

}
