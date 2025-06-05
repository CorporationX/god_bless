package school.faang.task_79176;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
public class Example {
    public List<Integer> reverse(List<Integer> array) {
        ArrayList<Integer> resultArray = new ArrayList<>();
        int arraySize = array.size();
        int i = 0;
        while (i < array.size()) {
            resultArray.add(array.get(arraySize - 1));
            arraySize--;
            i++;
        }
        return resultArray;
    }
}

