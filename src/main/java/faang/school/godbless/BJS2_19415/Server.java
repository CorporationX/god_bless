package faang.school.godbless.BJS2_19415;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString(onlyExplicitlyIncluded = true)
public class Server {
    private static final double MIN_POSSIBLE_LOAD = 0.0;
    private static final double LOAD_TO_ENERGY_FACTOR = 10.0;
    private static int serverIndex = 0;
    @ToString.Include
    @EqualsAndHashCode.Include
    private int id; //для генерации уникального hash
    @ToString.Include
    @EqualsAndHashCode.Include
    @Getter
    private final double maxLoad;
    @Getter
    @ToString.Include
    private double load;
    @Getter
    @ToString.Include
    private double energyConsumption;

    public Server(double maxLoad) {
        this.id = ++serverIndex;
        this.maxLoad = maxLoad;
        //при создании сервера нагрузка на сервер равна 0
        setLoadToMinValue();
    }

    public void setLoad(double load) {
        this.load = load;
        //потребление энергии зависит от нагрузки;
        this.energyConsumption = load * LOAD_TO_ENERGY_FACTOR;
    }

    public void setLoadToMaxValue() {
        setLoad(maxLoad);
    }

    public void setLoadToMinValue() {
        setLoad(MIN_POSSIBLE_LOAD);
    }
}

