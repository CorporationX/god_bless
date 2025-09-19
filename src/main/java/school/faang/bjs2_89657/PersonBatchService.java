package school.faang.bjs2_89657;

import org.apache.commons.collections4.ListUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static school.faang.bjs2_89657.Constant.MAX_AGE;
import static school.faang.bjs2_89657.Constant.MIN_AGE;
import static school.faang.bjs2_89657.Constant.SIZE_PERSON_LIST;

public class PersonBatchService {

    public static List<Person> createListPerson() {
        return IntStream.rangeClosed(0, SIZE_PERSON_LIST)
                .mapToObj(i -> new Person("name " + i, "surname " + i,
                        new Random().nextInt(MIN_AGE, MAX_AGE),
                        "workplace"))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public static void processPersons(List<Person> persons, int batchSize, ExecutorService executor) {
        ListUtils.partition(persons, batchSize)
                .stream()
                .map(PersonInfoPrinter::new)
                .forEach(executor::submit);
    }
}
