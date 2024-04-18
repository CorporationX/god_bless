package faang.school.godbless.module.third.parallelism.finger;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Location {
    private int x;
    private int y;
    
    public long getDistance(Location location) {
        return (long) Math.sqrt(Math.abs(Math.pow(location.getX() - this.x,2) + Math.pow(location.getY() - this.y,2)));
    }
    
    public void setLocation(Location location) {
        this.x = location.getX();
        this.y = location.getY();
    }
}
