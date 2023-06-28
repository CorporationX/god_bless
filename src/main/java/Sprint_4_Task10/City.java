package Sprint_4_Task10;


import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Map;
@AllArgsConstructor
@Data
public class City {
    private String name;
    private int x;
    private Map<String,Integer> map;

}
