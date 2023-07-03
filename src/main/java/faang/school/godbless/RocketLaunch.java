package faang.school.godbless;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class RocketLaunch implements Runnable{
    private String name;
    private LocalDateTime timeStart;

    public void run(){
        System.out.println("Rocket " + name + " starts launch ");
        try {
            System.out.println("3");
            Thread.sleep(1000);
            System.out.println("2");
            Thread.sleep(1000);
            System.out.println("1");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Rocket " + name + " starts !!!");
        System.out.println();
    }
}
