package faang.school.godbless.sprint5.multithreading_conc.task7_monitoring;

public class Main {

    public static void main(String[] args) {
        MonitoringSystem monitoringSystem = new MonitoringSystem();
        for (int i = 1; i < 6; i++) {
            Substation substation = new Substation(i, monitoringSystem);
            substation.startCalculatingAverages();
        }
    }
}
