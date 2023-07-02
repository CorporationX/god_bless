package faang.school.godbless.PavingTheWayWithYourFinger;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Data
public class City {
    private String name;
    private int location;
    private List<Integer> distances;


    public City(String name, int location, int velen, int toussaint, int whitOrchard, int skellige) {
        this.name = name;
        this.location = location;
        this.distances = new ArrayList<>();
        this.distances.add(velen);
        this.distances.add(toussaint);
        this.distances.add(whitOrchard);
        this.distances.add(skellige);
    }
}
