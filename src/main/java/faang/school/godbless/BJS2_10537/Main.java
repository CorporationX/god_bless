package faang.school.godbless.BJS2_10537;

import java.util.Arrays;
import java.util.List;

import static faang.school.godbless.BJS2_10537.MethodStream.sumEvenInt;
import static faang.school.godbless.BJS2_10537.MethodStream.maxValueInList;
import static faang.school.godbless.BJS2_10537.MethodStream.averageValue;
import static faang.school.godbless.BJS2_10537.MethodStream.minValueInList;
import static faang.school.godbless.BJS2_10537.MethodStream.quantityNeedLine;
import static faang.school.godbless.BJS2_10537.MethodStream.needLineList;
import static faang.school.godbless.BJS2_10537.MethodStream.sortLengthList;
import static faang.school.godbless.BJS2_10537.MethodStream.checkList;
import static faang.school.godbless.BJS2_10537.MethodStream.listLength;

public class Main {
    public static void main(String[] args){
        List<Integer> integerList = Arrays.asList(1 , 2 ,3 ,4, 5 , 6);
        List<String> stringList = Arrays.asList("apple" , "banana" , "orange" , "lemon" , "kiwi");

        System.out.println("List<Integer>: ");
        sumEvenInt(integerList);
        maxValueInList(integerList);
        averageValue(integerList);
        minValueInList(3,integerList);

        System.out.println("List<String: ");
        quantityNeedLine('a', stringList);
        needLineList("banana" , stringList);
        sortLengthList(stringList);
        checkList(5,stringList);
        listLength(stringList);




    }
}
