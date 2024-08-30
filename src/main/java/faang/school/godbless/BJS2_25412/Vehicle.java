package faang.school.godbless.BJS2_25412;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;

import java.util.Random;

@EqualsAndHashCode
@AllArgsConstructor
public class Vehicle {
    private final int id;
    private volatile Status status;
    private volatile Location location;

    public void setLocation() {
//        double t = new Random().nextDouble(-0.000020,0.000040);
//        System.out.println(Math.round((d+t)*1000000.0)/1000000.0);


        double newLatitude = location.getLatitude()+new Random().nextDouble(-0.030000,0.030000);
        location = new Location(location.getLatitude())
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
