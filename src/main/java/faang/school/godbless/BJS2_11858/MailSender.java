package faang.school.godbless.BJS2_11858;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MailSender {
    public static void main(String[] args) {
        int threadNums = 5;
        int count=0;
        int n = 0;
        for (int i=0; i<=1000+(threadNums-1);i++){
            count ++;
            if (count==200){
                var thread = new Thread(new SenderRunnable(i-199+n,i+1+n) );
                n++;
                count=0;
                thread.start();
            }
        }
        System.out.println("All thread were launched");
    }
}
