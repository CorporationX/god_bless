package faang.school.godbless.sprint_2.functional_interface.task_17_hogwarts.task_22_filter_spam;

import java.util.List;

public class MessageProcessor {

    public boolean processMessage(String message, List<MessageFilter> filters){

        for (MessageFilter f : filters) {
            if(!f.filter(message)){
                return false;
            }
        }
        return true;
    }
}
