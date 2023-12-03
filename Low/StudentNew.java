import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class StudentNew {

    static class Sonu{
        int count;
        double avg;
        int marks;

        public Sonu(){

        }

        public Sonu(int count,double avg,int marks){
            this.count = count;
            this.avg = avg;
            this.marks= marks;
        }
        @Override
        public String toString(){
            return "Average :"+avg;
        }


    }

    public static void main(String[] args) {
        String[][] s1 = { { "Rohan", "84" }, { "Sachin", "102" }, { "Ishan", "55" }, { "Sachin", "18" } };
        Map<String,Sonu> hm = new HashMap<>();
        double max = 0;
        for(String[] s:s1){
            hm.compute(s[0],(s2, sonu) -> sonu== null ? new Sonu(1,Double.parseDouble(s[1]),Integer.parseInt(s[1]))
                    :getAnswer(s,sonu));
        }

        System.out.println(max);
    }

    private static Sonu getAnswer(String[] s2 ,Sonu sonu) {
        int marks = sonu.marks + Integer.parseInt(s2[1]);
        int count = sonu.count+1;
        double avg = marks / count;
        return new Sonu(count,avg,marks);
    }
}
