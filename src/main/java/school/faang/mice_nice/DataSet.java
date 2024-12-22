package school.faang.mice_nice;

import lombok.experimental.UtilityClass;

@UtilityClass
public class DataSet {
    public static final int AMOUNT_OF_ROOMS = 5;
    public static final int AMOUNT_OF_FOODS_IN_ROOMS = 4;
    public static final int TOTAL_AMOUNT_OF_FOODS = AMOUNT_OF_FOODS_IN_ROOMS * AMOUNT_OF_ROOMS;
    public static final int THREAD_POOL_SIZE = 5;
    public static final int THREAD_TIMEOUT = 10;
    public static final int THREAD_INITIAL_DELAY = 1;
}
