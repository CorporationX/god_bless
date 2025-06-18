package school.faang.sprint3.bjs2_81109;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
public class Swordsman extends Unit {
    private double power = 40;
}
