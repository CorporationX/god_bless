package faang.school.godbless.sprint5.multithreading_conc.task7_monitoring;

import lombok.Getter;

@Getter
public class SensorData {

    private int count;

    private double sum;

    public void addData(double data){
        sum += data;
        count++;
    }

    public double getAvg(){
        return Math.ceil(sum/count * 100) / 100.0;
    }

    public void reset() {
        count = 0;
        sum = 0;
    }
}
