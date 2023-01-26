package map_reduce;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EmployeeDatabase {

    public static List<Employee> getEmployees() {
        return Stream.of(new Employee(101, "John", "A", 60000),
                new Employee(109, "Peter", "B", 30000),
                new Employee(102, "Kim", "A", 80000),
                new Employee(103,"Jason", "C", 15000),
                        new Employee(104, "Mak", "A", 90000))
                .collect(Collectors.toList());
    }
}
