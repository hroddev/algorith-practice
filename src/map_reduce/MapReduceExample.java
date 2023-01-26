package map_reduce;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class MapReduceExample {

    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(3, 7, 8, 1, 5, 9); // 33

        List<String> words = Arrays.asList("corejava", "spring", "hibernate");

        // method 1
        int sum = 0;
        for (int num : numbers) {
            sum = sum + num;
        }
        System.out.println(sum); // 33

        // method 2
        int sum1 = numbers.stream().mapToInt(i -> i).sum();
        System.out.println(sum1); // 33

        // method 3
        Integer sum2 = numbers.stream().reduce(0,(a, b)-> a + b);
        System.out.println(sum2); // 33

        // method 4
        Optional<Integer> reduceMethodReference = numbers.stream().reduce(Integer::sum);
        System.out.println(reduceMethodReference.get()); // 33

        // select the max value
        Integer maxvalue = numbers.stream().reduce(0, (a, b) -> a > b ? a : b);
        System.out.println(maxvalue); // 9

        // select max value with method reference
        Integer maxvalue2 = numbers.stream().reduce(Integer::max).get();
        System.out.println(maxvalue2); // 9

        // which the long word
        String longestWord = words.stream()
                .reduce((word1, word2) -> word1.length() > word2.length() ? word1 : word2)
                .get();
        System.out.println(longestWord);

        // get employee whose grade A
        // get salary

        double avgSalary = EmployeeDatabase.getEmployees().stream()
                .filter(employee -> employee.getGrade().equalsIgnoreCase("A"))
                .map(employee -> employee.getSalary())
                .mapToDouble(i -> i)
                .average().getAsDouble();
        System.out.println(avgSalary);

        double sumSalary = EmployeeDatabase.getEmployees().stream()
                .filter(employee -> employee.getGrade().equalsIgnoreCase("A"))
                .map(employee -> employee.getSalary())
                .mapToDouble(i -> i)
                .sum();
        System.out.println(sumSalary);
    }
}
