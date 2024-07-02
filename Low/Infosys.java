import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Infosys {
    static class Employee{
       int salary;

        @Override
        public String toString() {
            return "Employee{" +
                    "salary=" + salary +
                    '}';
        }

        Employee(int salary){
           this.salary=salary;
       }
    }
    public static void main(String[] args) {


        Thread t1 = new Thread(()-> System.out.println("Vaibhav"));
        t1.start();
        Employee employee= new Employee(23);
        Employee employee1= new Employee(22);
        Employee employee2= new Employee(21);

        List<Employee> ls = Arrays.asList(employee,employee1,employee2);

        List<Employee> ans = ls.stream().sorted((o1, o2) -> o1.salary - o2.salary).toList();
        System.out.println(ans);
        ans.get(ans.size()-2);





    }
}
