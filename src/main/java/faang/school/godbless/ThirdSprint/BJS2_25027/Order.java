package faang.school.godbless.ThirdSprint.BJS2_25027;

import lombok.Getter;
import lombok.Setter;

import java.util.concurrent.ThreadLocalRandom;

@Getter
@Setter
public class Order {
    private int id = ThreadLocalRandom.current().nextInt(1, 10_000);
    private String status = "Требует обработки";
}
