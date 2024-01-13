package faang.school.godbless.multi_con.task3zoom;

import lombok.AllArgsConstructor;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;

@AllArgsConstructor
public class Participant {
    private String name;

    public void joinConference(Conference conference) {
        try {
            Thread.sleep((long) (10000 * Math.random()));
            System.out.println(name + " присоединился к конфернции");
            conference.getBARRIER().await();
        } catch (InterruptedException | BrokenBarrierException e) {
            System.out.println("Конференция прервалась");
        }
    }
}
