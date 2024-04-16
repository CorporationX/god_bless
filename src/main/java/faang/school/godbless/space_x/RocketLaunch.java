package faang.school.godbless.space_x;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class RocketLaunch {
    private String name;
    private LocalDateTime localDateTime;

    public void launch() {
        System.out.println("Starting...");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e.getMessage());
        }
        System.out.println("Launch!");
    }
}
