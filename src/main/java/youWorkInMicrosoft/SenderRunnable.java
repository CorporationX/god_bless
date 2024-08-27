package youWorkInMicrosoft;

import lombok.Data;

import java.util.ArrayList;
import java.util.Objects;

@Data
public class SenderRunnable implements Runnable {

    int startIndex;
    int endIndex;
    ArrayList<Integer> listOfMails = new ArrayList<>();

    SenderRunnable(int startIndex, int endIndex, ArrayList<Integer> listOfMails) throws Exception {
        if (endIndex < startIndex) {
            throw new IllegalArgumentException("Конечный индекс не может быть меньше начального");
        } else if (listOfMails.size() < endIndex || listOfMails.size() < startIndex) {
            throw new IllegalArgumentException("Размер коллекции писем меньше чем переданные аргументы");
        } else {
            this.startIndex = startIndex;
            this.endIndex = endIndex;
            this.listOfMails = listOfMails;
        }
    }

    @Override
    public void run() {
        for (int i = startIndex; i < endIndex; i++) {
            System.out.println(listOfMails.get(i));
        }
    }
}
