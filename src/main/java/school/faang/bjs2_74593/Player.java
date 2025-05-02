package school.faang.bjs2_74593;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.concurrent.atomic.AtomicInteger;

@Data
@AllArgsConstructor
public class Player {
    private String name;
    private int level;
    private int experience;
}
