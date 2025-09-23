package school.faang.m1.thread.army;

import lombok.Getter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Squad<T extends Unit> {

    @Getter
    private final String name;

    @Getter
    private final List<T> squad = new ArrayList<>();

    public Squad(String name, List<? extends T> units) {
        this.name = name;
        if (units != null) {
            squad.addAll(units);  // безопасно: ? extends T
        }
    }

    public void add(T unit) {
        if (unit != null) {
            squad.add(unit);
        }
    }

    public void addAll(Collection<? extends T> units) {
        if (units != null) {
            squad.addAll(units);
        }
    }
}
