package faang.school.godbless.synchronizationWaitNotify.tamagotchiVlad;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
public class TamagotchiVlad {
    private String name;

    public synchronized void feed(){
        System.out.printf("Поток: %s. Тамагочи %s кормит Влада.\n", Thread.currentThread().getName(), name);
    }

    public synchronized void play(){
        System.out.printf("Поток: %s. Тамагочи %s играет с Владом.\n", Thread.currentThread().getName(), name);
    }

    public synchronized void clean(){
        System.out.printf("Поток: %s. Тамагочи %s чистит Влада.\n", Thread.currentThread().getName(), name);
    }

    public synchronized void sleep(){
        System.out.printf("Поток: %s. Тамагочи %s переводит Влада в режим сна.\n", Thread.currentThread().getName(), name);
    }
}
