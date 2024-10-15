package school.BJS2_36353;

public class Pig1Thread extends PigThread{

    public Pig1Thread(String pigName, String material) {
        super(pigName, material);
    }

    @Override
    public void run() {
        try {
            System.out.printf("Поросенок %s строит дом из материала %s",this.getPigName(),this.getMaterial());
            System.out.println();
            Thread.sleep(3000);
            System.out.printf("Дом у поросенка %s построен",this.getPigName());
            System.out.println();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}