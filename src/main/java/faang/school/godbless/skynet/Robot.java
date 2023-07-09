package faang.school.godbless.skynet;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.SneakyThrows;

@Data
@AllArgsConstructor
public class Robot {
    private String name;
    private final Target target;

    @SneakyThrows
    public void attack() {
        synchronized (target) {
            if (target.isAlive()) {
                System.out.println(name + " is terminating " + target.getName());
                Thread.sleep(4_000);
                target.setAlive(false);
                System.out.println(target.getName() + " is done x_x");
            }
        }
    }
}
