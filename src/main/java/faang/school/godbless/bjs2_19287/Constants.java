package faang.school.godbless.bjs2_19287;

import org.apache.commons.lang3.tuple.ImmutablePair;

import java.util.LinkedHashMap;
import java.util.Map;

public final class Constants {
    private Constants() {
    }

    public static final Double DEFAULT_MAX_LOAD = 100.0D;
    public static final Double DEFAULT_ENERGY_CONSUMPTION = 50.0D;
    public static final Map<ImmutablePair<Integer, Integer>, Double> ENERGY_CONSUMPTION_COEFFICIENT;
    public static final ImmutablePair<Integer, Integer> ALLOWED_UTILIZATION_INTERVAL = new ImmutablePair<>(25, 74);
    public static final Double CUSTOM_MAX_LOAD_COEFFICIENT = 2.0D;
    public static final Integer OPTIMAL_OPTIMIZATION = 49;

    static {
        ENERGY_CONSUMPTION_COEFFICIENT = new LinkedHashMap<>();
        ENERGY_CONSUMPTION_COEFFICIENT.put(new ImmutablePair<>(0, 24), 1.0d);
        ENERGY_CONSUMPTION_COEFFICIENT.put(new ImmutablePair<>(25, 49), 1.2d);
        ENERGY_CONSUMPTION_COEFFICIENT.put(new ImmutablePair<>(50, 74), 1.5d);
        ENERGY_CONSUMPTION_COEFFICIENT.put(new ImmutablePair<>(75, 100), 2.5d);
    }
}
