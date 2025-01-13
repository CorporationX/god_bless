package derschrank.sprint04.task20.bjstwo_51174;

public interface SubstationInterface {
    void receiveData(int sensorId, double data);

    void startCalculatingAverages();

    void stopCalculatingAverages();
}
