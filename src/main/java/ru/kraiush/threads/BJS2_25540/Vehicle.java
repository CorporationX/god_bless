package ru.kraiush.threads.BJS2_25540;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Setter
@ToString
@AllArgsConstructor
public class Vehicle implements Runnable {

    private int id;
    private boolean status;
    private Location location;

    public boolean isStatus() {
        return status;
    }

    public Location getLocation() {
        return location;
    }

    @Override
    public void run() {
        System.out.println("Vehicle-" + id + " status: " + status + " location: " + location + " " + " Start. Time = " + new Date());
    }
}
