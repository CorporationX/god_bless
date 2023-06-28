package you_work_for_microsoft;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SenderRunnable implements Runnable{
    private int startIndex;
    private int endIndex;
    public SenderRunnable(int startIndex, int endIndex){
        this.startIndex = startIndex;
        this.endIndex = endIndex;
    }

    public void run(){
        int x = startIndex;
        for (int i = startIndex; i < endIndex; i++) {
            x++;
            System.out.println("The email has been sent "+x);
        }
    }
}
