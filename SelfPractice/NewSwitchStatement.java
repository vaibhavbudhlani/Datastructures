package SelfPractice;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

enum Months{
    JAN("January"),
    FEB("February");

    private final String monthName;

    Months(String monthName) {
        this.monthName = monthName;
    }

    public String getMonthName() {
        return this.monthName;
    }
}

public class NewSwitchStatement {
    public static void main(String[] args) {
        Months month = Months.JAN;
        List<Integer> ls = Arrays.asList(2,3,4,5);
        int ans = ls.stream().reduce(0,(a,b) -> a+b);
//        ls.stream().collect(Collectors.toMap(x->x,y->y ));
        System.out.println(ans);
       // System.out.println(jan.getMonthName());

//        int ans = switch (month) {
//            case JAN -> 3;
//           // case FEB -> 1;
//            default -> throw new IllegalStateException("Unexpected value: " + month);
//        };
        System.out.println(ans);
    }
}
