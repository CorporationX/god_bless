package googlemaps;

public record Location(String name, double latitude, double longitude) {
    @Override
    public String toString() {
        return String.format("%s (%s, %s)", name, latitude, longitude);
    }
}
