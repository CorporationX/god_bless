package derschrank.sprint04.task22.bjstwo_51227.units;

public record Location(
        double latitude,
        double longitude
) {
    @Override
    public String toString() {
        return String.format("[%f:%f]", latitude, longitude);
    }
}
