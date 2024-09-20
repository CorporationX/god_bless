package ru.kraiush.threads.BJS2_18367;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Random;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class Sensor {

    private int substationId;
    //    private Substation station;
    private int id;
    private double data;


    public Sensor(int substationId, int id) {
        this.substationId = substationId;
        this.id = id;
    }

    public Double generatingData() {
        double lowerBound = 10;
        double upperBound = 1000;
        return lowerBound + new Random().nextDouble() * (upperBound - lowerBound);
    }
}
