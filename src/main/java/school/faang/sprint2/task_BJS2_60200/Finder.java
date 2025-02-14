package school.faang.sprint2.task_BJS2_60200;

import school.faang.sprint2.task_BJS2_60200.employee.SalaryDepartmentAverager;
import school.faang.sprint2.task_BJS2_60200.employee.Department;
import school.faang.sprint2.task_BJS2_60200.employee.Employee;
import school.faang.sprint2.task_BJS2_60200.people.Pair;
import school.faang.sprint2.task_BJS2_60200.people.PairGenerator;
import school.faang.sprint2.task_BJS2_60200.people.Person;

import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class Finder {
    public Set<Pair> findPeopleWithMutualFriends(Map<Person, Set<Person>> peopleWithFriends) {
        validMap(peopleWithFriends);
        Set<Pair> pairOfPeople = new HashSet<>();
        PairGenerator pairGenerator = new PairGenerator(peopleWithFriends);
        
        Set<Person> persons = peopleWithFriends.values().stream()
                .filter(Objects::nonNull)
                .flatMap(Collection::stream)
                .filter(Objects::nonNull)
                .collect(Collectors.toSet());

        persons.forEach(friend -> {
            peopleWithFriends.forEach((person, friends) -> {
                if (person != null && person != friend && friends.contains(friend)) {
                    pairGenerator.addPerson(person);
                }
            });
            pairOfPeople.addAll(pairGenerator.generateAllPairs());
        });
        return pairOfPeople;
    }

    public Map<Department, Double> getAverageSalaryOfDepartments(Set<Employee> employees) {
        SalaryDepartmentAverager salaryDepartmentAverager = new SalaryDepartmentAverager();
        employees.forEach(salaryDepartmentAverager::addEmployee);
        return salaryDepartmentAverager.getAverageSalaryOfDepartments();
    }

    private <T, U> void validMap(Map<T, U> peopleWithFriends) {
        if (peopleWithFriends == null || peopleWithFriends.isEmpty()) {
            throw new IllegalArgumentException("Карта не может быть пустой");
        }
    }
}
