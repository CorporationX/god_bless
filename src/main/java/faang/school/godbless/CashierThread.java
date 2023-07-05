package faang.school.godbless;

import lombok.AllArgsConstructor;


@AllArgsConstructor
public class CashierThread extends Thread{
    private int cashierId;
    private int[] customerItems;

    @Override
    public void run(){
        for(int item: customerItems){
            try{
                Thread.sleep(500);
                System.out.printf("Cashier %d processed item number %d \n", cashierId, item);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
