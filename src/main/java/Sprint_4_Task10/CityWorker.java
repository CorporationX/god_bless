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
    public void totalTravelTime(){

    }
    public void timingToKillFAMonster(){

    }
    public void searchForTheNearestMonster(){
    }
}
