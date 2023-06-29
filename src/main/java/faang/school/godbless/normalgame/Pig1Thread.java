package faang.school.godbless.normalgame;

import lombok.SneakyThrows;

public class Pig1Thread extends PigThread {

    public Pig1Thread(String pigName, String material) {
        super(pigName, material);
    }

    @SneakyThrows
    @Override
    public void run() {
        System.out.println(this.getPigName() + " начал строительство дома из " + this.getMaterial());
        Thread.sleep(1500);

        System.out.println(this.getPigName() + " заложил фундамент");
        Thread.sleep(1000);

        System.out.println(this.getPigName() + " приступил к строительству стен и крыши");
        Thread.sleep(2000);
        System.out.println(this.getPigName() + " построил дом");
    }
}
