package faang.school.godbless.BJS25695;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RocketLaunch {
    private String name;
    private long launchTime;

    public void launch() {
        try {
            Thread.sleep(1000);
            System.out.println("Ракета '" + name + "' успешно запущена!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
