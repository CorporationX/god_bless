package school.faang.bjs2_60604;

public class SenderRunnable  implements Runnable{
    private int startIndex;
    private int endIndex;

    @Override
    public void run() {
        for (int i = startIndex; i <endIndex; i++){
            System.out.println("Письмо отправлено");
        }
    }
}
