package faang.school.godbless.spaceX;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;

@AllArgsConstructor
@Getter
public class RocketLaunch {
    private String name;
    private Date launchTime;

    public void launch() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.err.println("ракета" + name + " не запущена");
            e.printStackTrace();
            throw new RuntimeException();
        }

        System.out.println(name + ", поехали!!!");
    }
}
