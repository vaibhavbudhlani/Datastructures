import java.util.*;
import java.util.stream.Collectors;

public class EpamTest {

    //Write a function that takes a list of employees and returns a map where
    // the keys are departments, and the values are lists of employees sorted by their age in descending order.

    public static void main(String[] args) {

        List<Employee> employee = Arrays.asList(

                new Employee("Alice", 28, 60000, "HR"),

                new Employee("Bob", 35, 75000, "Engineering"),

                new Employee("Charlie", 32, 90000, "Engineering"),

                new Employee("David", 40, 80000, "HR"),

                new Employee("Eva", 28, 70000, "Finance"),

                new Employee("Frank", 45, 95000, "Finance")

        );

        System.out.println(getEmployees(employee));



    }


    public static  Map<String,List<Employee>> getEmployees(List<Employee> ls){

//        List<Employee> descendingList = ls.stream().sorted((o1, o2) -> o2.getAge() - o1.getAge()).toList();
        // <departments ,List<>>

        Map<String,List<Employee>> map = new HashMap<>();

        for(Employee emp: ls){
            map.put(emp.getDepartment(),ls.stream().
                    filter(employee -> employee.getDepartment().equals(emp.getDepartment()))
                            .sorted((o1, o2) -> o2.getAge()- o1.getAge())
                    .collect(Collectors.toList()));
        }


        return ls.stream()
                .sorted(Comparator.comparingInt(Employee::getAge).reversed())
                .collect(Collectors.groupingBy(Employee::getDepartment));

       // return map;




    }




}
