package school.faang.monitorelectrsubstations;

public class Main {
    private static final int SENSOR_COUNT = 10;
    private static final int SUBSTATION_1_ID = 1;
    private static final int SUBSTATION_2_ID = 2;

    public static void main(String[] args) {
        MonitoringSystem monitoringSystem = new MonitoringSystem();

        Substation substation1 = createAndStartSubstation(SUBSTATION_1_ID, monitoringSystem, 0);
        Substation substation2 = createAndStartSubstation(SUBSTATION_2_ID, monitoringSystem, SENSOR_COUNT);

        substation1.startCalculatingAverages();
        substation2.startCalculatingAverages();
    }

    private static Substation createAndStartSubstation(int substationId, MonitoringSystem monitoringSystem, int sensorIdOffset) {
        Substation substation = new Substation(substationId, monitoringSystem);
        for (int i = 0; i < SENSOR_COUNT; i++) {
            new Sensor(i + sensorIdOffset, substation).startGeneratingData();
        }
        return substation;
    }
}

