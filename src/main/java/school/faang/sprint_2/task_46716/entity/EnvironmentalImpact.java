package school.faang.sprint_2.task_46716.entity;

import lombok.Getter;

import java.time.LocalDate;
import java.util.concurrent.atomic.AtomicInteger;

@Getter
public class EnvironmentalImpact {
    private static final AtomicInteger idCounter = new AtomicInteger(1);

    private final int id;
    private final int companyId;
    private final double volume;
    private final LocalDate date;
    private final ImpactType type;

    public EnvironmentalImpact(int companyId, double volume, LocalDate date, ImpactType type) {
        this.id = idCounter.getAndIncrement();
        this.companyId = companyId;
        this.volume = volume;
        this.date = date;
        this.type = type;
    }

    public EnvironmentalImpact(int id, int companyId, double volume, LocalDate date, ImpactType type) {
        this.id = id;
        idCounter.set(id + 1);
        this.companyId = companyId;
        this.volume = volume;
        this.date = date;
        this.type = type;
    }
}
