package faang.school.godbless.FourthSprint.bjs2_50335;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Order {
    private int id;
    private volatile String status;
}
