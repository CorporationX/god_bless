package lru;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Data {
    private int id;
    private String value;
    private int timestamp;
}
