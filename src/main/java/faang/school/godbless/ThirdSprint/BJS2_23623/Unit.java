package faang.school.godbless.ThirdSprint.BJS2_23623;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.util.concurrent.atomic.AtomicInteger;

@ToString

@Getter

public abstract class Unit{
    int power;

    public abstract int totalPowerIncrement(int delta);
    public abstract int getTotalPower();
}
