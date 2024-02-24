package faang.school.godbless.finallygoodgame2980.pigthreads;

import lombok.Getter;

@Getter
public class PigThread extends Thread {
    private String pigName;
    private String material;

    protected PigThread(String pigName, String material) {
        this.pigName = pigName;
        this.material = material;
    }

    @Override
    public void run() {
        System.out.println("Just checking if extending went alright. If you read this, wish you all the best");
    }
}
