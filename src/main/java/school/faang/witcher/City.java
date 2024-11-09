package school.faang.witcher;
public class City {
    private String cityName;
    private location loc;

    public City(String name, location l) {
        cityName = name;
        loc = l;
    }

    public String Name() {
        return cityName;
    }

    public location getLocation() {
        return loc;
    }
}
