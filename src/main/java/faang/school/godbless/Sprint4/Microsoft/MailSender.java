package faang.school.godbless.Sprint4.Microsoft;

public class MailSender {
    public static void main(String[] args) throws InterruptedException {
        int latter=1000;
        int n =5;
        int step = latter/n;
        int sPoint=0;
        //почему элементы идут по порядку ?
        for (int i=0;i<n;i++){
            Thread thread = new Thread(new SenderRunnable(sPoint, step+sPoint));
            thread.start();
            thread.join();
            sPoint+=step;
        }
    }
}
