package Multithreading.bc2127;

import lombok.Getter;

@Getter
public class Pig1Thread extends PigThread {
    public Pig1Thread(String pigName, int material) {
        super(pigName, material);
    }
}
