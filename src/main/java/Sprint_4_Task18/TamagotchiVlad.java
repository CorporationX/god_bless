package Sprint_4_Task18;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TamagotchiVlad {
    private String name;

    public synchronized void feed(){
        System.out.println(Thread.currentThread().getName() + " Vlad is eating " + getName());
    }
    public synchronized void play(){
        System.out.println(Thread.currentThread().getName() + " Vlad is playing " + getName());
    }
    public synchronized void clean(){
        System.out.println(Thread.currentThread().getName() + " Vlad is cleaning " + getName());
    }
    public synchronized void sleep(){
        System.out.println(Thread.currentThread().getName() + " Vlad is sleeping " + getName());
    }
}
