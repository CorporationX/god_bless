package derschrank.sprint04.task07.bjstwo_50256;

import java.util.Optional;

public record Fighting(
        Robot robot1,
        Robot robot2,
        Optional<Robot> winner
){
}
