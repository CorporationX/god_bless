package school.faang.bjs2_93246;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        MonitoringSystem monitoringSystem = new MonitoringSystem();

        Substation substation1 = new Substation(1, monitoringSystem);
        for (int i = 1; i <= 10; i++) {
            Sensor sensor = new Sensor(100 + i, substation1);
            sensor.startGeneratingData();
        }

        Substation substation2 = new Substation(2, monitoringSystem);
        for (int i = 1; i <= 10; i++) {
            Sensor sensor = new Sensor(200 + i, substation2);
            sensor.startGeneratingData();
        }

        Substation substation3 = new Substation(3, monitoringSystem);
        for (int i = 1; i <= 10; i++) {
            Sensor sensor = new Sensor(300 + i, substation3);
            sensor.startGeneratingData();
        }

        substation1.startCalculatingAverages();
        substation2.startCalculatingAverages();
        substation3.startCalculatingAverages();

        for (int minute = 1; minute <= 3; minute++) {
            Thread.sleep(60000);
            System.out.println("--------------------");
            monitoringSystem.printAllData();
        }

        System.out.println("------------------------");
        System.out.printf("Final overall average: %.2f%n", monitoringSystem.getOverallAverage());

        System.exit(0);
    }
}
