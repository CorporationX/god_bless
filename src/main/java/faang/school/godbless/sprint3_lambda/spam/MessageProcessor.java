package faang.school.godbless.sprint3_lambda.spam;

import java.util.List;

public class MessageProcessor {

    public void isValid(String line, List<MessageFilter> filters){
        if (line == null || line.isEmpty()){
            throw new IllegalArgumentException("Пустая строка");
        } else if (filters == null || filters.isEmpty()) {
            throw new IllegalArgumentException("Пустой лист");
        }
    }
    public void processMessage(String line, List<MessageFilter> filters) {
        isValid(line, filters);
        int count = 1;
        for (MessageFilter message : filters) { // for(ObjectInterface x: name(список List))
            if (!message.filter(line)){  // (message.filter(stroke)- if x проходит условие фун.интерфейса, то принимает stroke
                throw new IllegalArgumentException("Строка: " + line+ " не прошел " + count + " фильтр");
            }else {
                System.out.println("Строка: " + line+ " прошла " + count + " фильтр");
                count++;
            }
        }
    }
}
