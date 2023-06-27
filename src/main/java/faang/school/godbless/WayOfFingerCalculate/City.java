package faang.school.godbless.WayOfFingerCalculate;

import lombok.Getter;

import java.util.List;

@Getter
public class City {
    private String name;
    private int location;
    private int distanceToFirstCity;
    private int distanceToSecondCity;
    private int distanceToThirdCity;

    private City(String name, int location, int distanceToFirstCity,
                 int distanceToSecondCity, int distanceToThirdCity) {
        this.name = name;
        this.location = location;
        this.distanceToFirstCity = distanceToFirstCity;
        this.distanceToSecondCity = distanceToSecondCity;
        this.distanceToThirdCity = distanceToThirdCity;
    }

    public static List<City> getCites(){
        City novigrad = new City("Novigrad",0,60,120,80);
        City oxenfurt = new City("Oxenfurt",60,0,50,70);
        City vizima = new City("Vizima",120,50,0,30);
        City kaerMorhen = new City("Kaher Morhen",180,70,30,0);
        return List.of(novigrad,oxenfurt,vizima,kaerMorhen);


    }

}
