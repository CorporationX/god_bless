package Multithreading.bc3008;

import java.util.ArrayList;
import java.util.List;

public class House {
    List<String> list = new ArrayList<>();
    private int countFreeRole;


    public void addRole() {
        countFreeRole--;
    }

    public void removeRole() {
        countFreeRole++;
        notifyAll();
    }
}
