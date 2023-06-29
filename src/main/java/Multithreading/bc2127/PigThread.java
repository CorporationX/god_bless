package Multithreading.bc2127;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class PigThread extends Thread {
    private String pigName;
    private int material;
}
