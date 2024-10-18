package ru.kraiush.BJS2_35961;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class PersonInfoPrinter implements Runnable {
    private List<Person> people;

    @Override
    public void run() {
        for (Person person : people) {
            StringBuilder sb = new StringBuilder();
            String personInfo = sb
                    .append("Name Surname: ")
                    .append(person.getName())
                    .append(" ")
                    .append(person.getSurname())
                    .append(", age: ")
                    .append(person.getAge())
                    .append(", workplace: ")
                    .append(person.getWorkplace())
                    .toString();
            System.out.println(personInfo);
        }
    }
}
