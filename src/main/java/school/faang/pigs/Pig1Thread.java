package school.faang.pigs;

public class Pig1Thread extends PigThread {
    public Pig1Thread(String pigName, String material) {
        super(pigName, material);
    }

    @Override
    public String getMaterial() {
        return super.getMaterial();
    }

    @Override
    public String getPigName() {
        return super.getPigName();
    }

    @Override
    public void run() {
        System.out.println(getPigName() + " строит дом из " + getMaterial());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new IllegalStateException("Поток был прерван", e);
        }
        System.out.println(getPigName() + " завершил строительство дома из " + getMaterial());
    }
}
