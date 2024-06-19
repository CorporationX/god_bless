package faang.school.godbless.multithreading_parallelism.task_7;

public record Monster(String name, String location) {
    public Location getLocation() {
        return switch (location) {
            case "Velen" -> new Location(60, 10);
            case "Toussaint" -> new Location(20, 50);
            case "White Orchard" -> new Location(40, 80);
            case "Skellige" -> new Location(50, 30);
            default -> new Location(0, 0);
        };
    }
}
