package school.faang.task_51442;

public class SubstationMonitoringApp {
    public static void main(String[] args) {
        MonitoringSystem monitoringSystem = new MonitoringSystem();

        Substation substation1 = new Substation(1, monitoringSystem);
        Substation substation2 = new Substation(2, monitoringSystem);

        for (int i = 0; i < 10; i++) {
            new Sensor(i, substation1).startGeneratingData();
            new Sensor(i + 10, substation2).startGeneratingData();
        }

        substation1.startCalculatingAverages();
        substation2.startCalculatingAverages();

        try {
            Thread.sleep(60000); // Run for 1 minute
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Monitoring completed.");
    }
}

