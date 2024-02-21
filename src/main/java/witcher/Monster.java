package witcher;

public class Monster {
    private String name;
    private String location;

    public Location getCoordinates(){
        switch (location){
            case "Velen" -> {
                return new Location(0,90);
            }
            case "Toussaint" -> {
                return new Location(200, 75);
            }
            case "White Orchard" -> {
                return new Location(50, 50);
            }
            case "Skellige" -> {
                return new Location(-190, -20);
            }
            default -> return new Location(0,0);
        }
    }

    public Monster(String name, String location) {
        this.name = name;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }
}
