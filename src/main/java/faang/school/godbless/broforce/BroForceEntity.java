package faang.school.godbless.broforce;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public abstract class BroForceEntity {
    private String name;
    private int lives;
    private InGameType type;
}
