package faang.school.godbless.substationsMonitoring;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        MonitoringSystem monitoringSystem = new MonitoringSystem();

        Substation substation1 = new Substation(1);
        Substation substation2 = new Substation(2);

        for (int i = 1; i <= 10; i++) {
            substation1.addSensor(new Sensor(i, substation1));
        }
        for (int i = 11; i <= 20; i++) {
            substation2.addSensor(new Sensor(i, substation2));
        }

        monitoringSystem.addSubstation(substation1);
        monitoringSystem.addSubstation(substation2);

        substation1.startReceivingData();
        substation2.startReceivingData();

        monitoringSystem.startReporting();

        Thread.sleep(180000);

        substation1.stopReceivingData();
        substation2.stopReceivingData();

        monitoringSystem.stopReporting();
    }
}
