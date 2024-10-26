package school.faang.BJS236364;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class PigThread extends Thread {
    private String pigName;
    private String material;
}
