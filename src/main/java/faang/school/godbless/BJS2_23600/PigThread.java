package faang.school.godbless.BJS2_23600;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class PigThread extends Thread {

    private String pigName;
    private int material;

}
