package Sprint_4_Task10;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
@Data
@AllArgsConstructor
public class CityWorker implements Runnable{
    City city;
    List<Monster> monster;
    @Override
    public void run() {
    }
    public Monster findNearestMonster(City city, List<Monster> monsters){

    }
    public long getKillTime(){

    }
    public long getJourneyDistance(){

    }
    public Location getLocationCoordinates(String location) {
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
