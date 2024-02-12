    package faang.school.godbless;

    import java.util.ArrayList;
    import java.util.List;

    public class MessageProcessor {
        public List<MessageFilter> processMessage(String message, List<MessageFilter> filters){

            List<MessageFilter> passedFilters = new ArrayList<>();

            for(MessageFilter element : filters){
                if(element.filter(message)){
                    passedFilters.add(element);
                }
            }
            return passedFilters;
        }
    }
