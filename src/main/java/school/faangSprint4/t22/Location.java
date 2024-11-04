package school.faangSprint4.t22;

public record Location(double latitude, double longitude) {

    @Override
    public String toString() {
        return "Location{latitude=" + latitude + ", longitude=" + longitude + '}';
    }
}