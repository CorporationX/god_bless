package sprint_4.sprint_4_1_async_future.tournamentTriwizard_39044;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Student {
    private String name;
    private int year;
    private int points;

    public void addPoints(int points){
        this.points += points;
    }
}
