package Sprint_3.BJS2_36483;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PigThread extends Thread {

    private String pigName;
    private String material;

    public PigThread(String pigName, String material) {
        this.pigName = pigName;
        this.material = material;
    }

    public void run() {
    }
}
