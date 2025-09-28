package school.faang.bjs2_93246;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        MonitoringSystem monitoringSystem = new MonitoringSystem();
        List<SubstationData> substationDataList = getSubstationData(monitoringSystem);

        for (SubstationData substationData : substationDataList) {
            substationData.startCalculatingAverages();
        }

        for (int minute = 1; minute <= 3; minute++) {
            Thread.sleep(60000);
            System.out.println("--------------------");
            monitoringSystem.printAllData();
        }

        System.out.println("------------------------");
        System.out.printf("Final overall average: %.2f%n", monitoringSystem.getOverallAverage());

        System.exit(0);
    }

    private static List<SubstationData> getSubstationData(MonitoringSystem monitoringSystem) {
        SensorData sensorData = new SensorData();

        List<SubstationData> substationDataList = new ArrayList<>();
        for (int i = 1; i <= 3; i++) {
            Substation substation = new Substation(i);
            SubstationData substationData = new SubstationData(substation, monitoringSystem);
            for (int j = 1; j <= 10; j++) {
                Sensor sensor = new Sensor(j, substation);
                sensorData.startGeneratingData(sensor);
            }
            substationDataList.add(substationData);
        }
        return substationDataList;
    }
}