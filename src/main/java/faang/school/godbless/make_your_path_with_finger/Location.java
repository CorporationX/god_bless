package faang.school.godbless.make_your_path_with_finger;

public record Location(int x, int y) {
    public static double distance(Location a, Location b) {
        if(a == null) {
            throw new NullPointerException("Location 1 cannot be null");
        }
        if(b == null) {
            throw new NullPointerException("Location 2 cannot be null");
        }
        return Math.sqrt(Math.pow(b.x - a.x, 2) + Math.pow(b.y - a.y, 2));
    }

    public static Location getLocationCoordinates(String location) {
        switch (location) {
            case "Velen" -> {
                return new Location(10, 20);
            }
            case "Toussaint" -> {
                return new Location(40, 50);
            }
            case "White Orchard" -> {
                return new Location(100, 10);
            }
            case "Skellige" -> {
                return new Location(80, 120);
            }
            default -> {
                return new Location(0, 0);
            }
        }
    }
}
