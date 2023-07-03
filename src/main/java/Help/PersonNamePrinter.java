package Help;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class PersonNamePrinter implements Runnable{
    private Person person;
    public void run() {
        System.out.println(person.getName());
    }
}
