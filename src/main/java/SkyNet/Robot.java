package SkyNet;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Robot {
    private String  target;

    public void attack(){
        synchronized (target) {
            System.out.println("Robot is attacking " + target);
        }
    }
}
