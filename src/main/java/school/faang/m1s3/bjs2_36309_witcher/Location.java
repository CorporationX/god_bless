package school.faang.m1s3.bjs2_36309_witcher;

import lombok.Data;

import java.util.Random;

@Data
public class Location {
    private int x;
    private int y;
    private Random random = new Random();

    public Location() {
        this.x = random.nextInt(0, 100);
        this.y = random.nextInt(0, 100);
    }
}

