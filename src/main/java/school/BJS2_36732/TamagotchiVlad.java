package school.BJS2_36732;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class TamagotchiVlad {

    private String TamagotchiVladName;

    public synchronized void feed(String TamagotchiVladName) throws InterruptedException {
        System.out.println(TamagotchiVladName + " спит");
        Thread.sleep(2000);
        System.out.println(TamagotchiVladName + " выспался");
    }
    public synchronized void play(String TamagotchiVladNumber) throws InterruptedException {
        System.out.println(TamagotchiVladName + " играет");
        Thread.sleep(2000);
        System.out.println(TamagotchiVladName + " наигрался");
    }
    public synchronized void clean(String TamagotchiVladNumber) throws InterruptedException {
        System.out.println(TamagotchiVladName + " чистит");
        Thread.sleep(2000);
        System.out.println(TamagotchiVladName + " помылся");
    }
    public synchronized void sleep(String TamagotchiVladName) throws InterruptedException {
        System.out.println(TamagotchiVladName +" спит");
        Thread.sleep(2000);
        System.out.println(TamagotchiVladName + " выспался");
    }
}