package faang.school.godbless.sprint4.electro;

public class Main {
    public static void main(String[] args) {
        MonitoringSystem monitoringSystem = new MonitoringSystem();

        Substation substation = new Substation(1, monitoringSystem);

        Sensor sensor = new Sensor(1, substation);
        Sensor sensor2 = new Sensor(2, substation);
        Sensor sensor3 = new Sensor(3, substation);
        Sensor sensor4 = new Sensor(4, substation);
        Sensor sensor5 = new Sensor(5, substation);
        Sensor sensor6 = new Sensor(6, substation);
        Sensor sensor7 = new Sensor(7, substation);
        Sensor sensor8 = new Sensor(8, substation);
        Sensor sensor9 = new Sensor(9, substation);
        Sensor sensor10 = new Sensor(10, substation);

        sensor.startGeneratingData();
        sensor2.startGeneratingData();
        sensor3.startGeneratingData();
        sensor4.startGeneratingData();
        sensor5.startGeneratingData();
        sensor6.startGeneratingData();
        sensor7.startGeneratingData();
        sensor8.startGeneratingData();
        sensor9.startGeneratingData();
        sensor10.startGeneratingData();

        substation.startCalculatingAverages();

        monitoringSystem.showAverage();
    }
}
