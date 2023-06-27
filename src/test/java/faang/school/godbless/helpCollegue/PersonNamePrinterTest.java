package faang.school.godbless.helpCollegue;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PersonNamePrinterTest {
    @Test
    void Test_constructorThrowNullPointerException(){
        List<Person> people = new ArrayList<Person>();
        NullPointerException result = assertThrows(NullPointerException.class, () -> new PersonNamePrinter(people));
        assertEquals("", result.getMessage());
    }

}