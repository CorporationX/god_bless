package school.faang.BJS2_92822;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class Student {
    private final String name;
    private final int years;
    private AtomicBoolean isBusy;
    private int points;
}
