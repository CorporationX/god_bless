package school.BJS2_36353;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class PigThread extends Thread{

    private String pigName;
    private String material;

}