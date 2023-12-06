package faang.school.godbless.walmart;

import lombok.Data;
import lombok.NonNull;

@Data
public class CashierThread extends Thread{
    @NonNull
    private int cashierID;
    @NonNull
    private String[] customerItems;

    public static int items;

    @Override
    public void run() {
        for(var item : customerItems){
            System.out.println("Приобретён товар - " + item);
            synchronized (this) {
                items++;
            }
        }
    }
}
