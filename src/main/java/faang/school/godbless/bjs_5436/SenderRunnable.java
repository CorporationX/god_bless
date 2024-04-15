package faang.school.godbless.bjs_5436;


import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SenderRunnable implements Runnable {

    private int startIndex;
    private int endIndex;

    @Override
    public void run() {
        System.out.println("Mails from " + startIndex + " to " + endIndex + " were sent");
    }
}
