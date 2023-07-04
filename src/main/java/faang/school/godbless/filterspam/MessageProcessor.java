import java.util.List;

public class MessageProcessor {
    public boolean processMessage(String message, List<MessageFilter> filters){
        for (MessageFilter filter2: filters) {
            if(!filter2.filter(message)){
                return false;
            }
        }
        return true;
    }
}
