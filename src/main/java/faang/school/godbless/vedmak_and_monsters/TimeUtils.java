package faang.school.godbless.vedmak_and_monsters;

public class TimeUtils {
    private static final long NANO_IN_SEC = 1000_000_000L;
    private static final long ROUNDING_FACTOR = 1000L;

    public static double secondElapsedTime(Long startTimeNano, Long endTimeNano) {
        return Math
                .ceil((double) (endTimeNano - startTimeNano) / NANO_IN_SEC * ROUNDING_FACTOR) / ROUNDING_FACTOR;
    }
}
