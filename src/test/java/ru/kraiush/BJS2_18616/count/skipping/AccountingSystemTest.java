package ru.kraiush.BJS2_18616.count.skipping;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import school.faang.count.skipping.AccountingSystem;
import school.faang.count.skipping.Student;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AccountingSystemTest {
    private AccountingSystem accountingSystem;

    @BeforeEach
    public void setUp() {
        accountingSystem = new AccountingSystem();
    }

    @Test
    public void testAdd() {
        //arrange
        var student = new Student("Filip", new Course("Ecology", 2));

        //act
        accountingSystem.add(student);

        //assert
        List<Student> students = accountingSystem.get(new Course("Ecology", 2));
        assertTrue(students.contains(student));
    }

    @Test
    public void testRemove() {
        //arrange
        var student = new Student("Filip", new Course("Ecology", 2));
        accountingSystem.add(student);

        //act
        accountingSystem.remove(student.getName());

        //assert
        List<Student> students = accountingSystem.get(new Course("Ecology", 2));
        assertNull(students);
    }

    @Test
    public void testGet() {
        //arrange
        var student = new Student("Filip", new Course("Ecology", 2));
        accountingSystem.add(student);
        List<Student> expected = List.of(student);

        //act
        List<Student> actual = accountingSystem.get(new Course("Ecology", 2));

        //assert
        assertEquals(expected, actual);
    }
}
