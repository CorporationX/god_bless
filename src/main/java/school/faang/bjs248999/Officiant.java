package school.faang.bjs248999;


import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Officiant extends Thread {

    private final House house;

    @Override
    public void run() {
        house.collectFood();
    }
}
