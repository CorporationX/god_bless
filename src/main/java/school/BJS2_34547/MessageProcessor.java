package school.BJS2_34547;

import java.util.List;

public class MessageProcessor {

    public boolean processMessage(String text, List<MessageFilter> list) {
        boolean check = true;
        for (MessageFilter x : list) {
            check = x.filter(text);
            if(!check) {
                break;
            }
        } return check;
    }

}