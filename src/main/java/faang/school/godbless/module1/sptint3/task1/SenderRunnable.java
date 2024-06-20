package faang.school.godbless.module1.sptint3.task1;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SenderRunnable implements Runnable{
    private int startIndex;
    private int endIndex;


    public static void sentMessage(int number){
        System.out.println("Message " + number + " sent");
    }

    @Override
    public void run() {
        for (int i = startIndex; i < endIndex; i++) {
            sentMessage(i);
        }
    }


}
