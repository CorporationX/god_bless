package school.faang.nicemice;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Officiant extends Thread {
    House house = new House();

    @Override
    public void run() {
        house.collectFood();
    }
}
