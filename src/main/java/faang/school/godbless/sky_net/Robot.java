package faang.school.godbless.sky_net;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Robot {
    private String target;

    public synchronized void attack() {
            System.out.println(target + " destroyed!");
    }
}
