package faang.school.godbless.BJS2_3345;


import lombok.Value;

import java.util.concurrent.atomic.AtomicInteger;

@Value
public class Donation {
    public static AtomicInteger lastId = new AtomicInteger(0);
    int id;
    int value;

    Donation(int value){
        this.id = lastId.incrementAndGet();
        this.value = value;
    }
}
