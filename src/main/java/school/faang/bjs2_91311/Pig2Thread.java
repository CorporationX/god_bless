package school.faang.bjs2_91311;

public class Pig2Thread extends PigThread {
    public Pig2Thread(String pigName, String material) {
        super(pigName, material);
    }

    @Override
    public void run() {
        System.out.printf("Поросенок %s начал строить дом, используя %s.%n", getPigName(), getMaterial());
        try {
            Thread.sleep(getBUILDING_TIME());
            System.out.printf("Поросенок %s закончил строить дом, используя %s.%n", getPigName(), getMaterial());
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.printf("Поросенок %s не успел достроить дом, пришел волк, пришлось бежать прятаться.%n",
                    getPigName());
        }
    }
}
