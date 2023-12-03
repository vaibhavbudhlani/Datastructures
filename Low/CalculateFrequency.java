import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CalculateFrequency {
    public static void main(String[] args) {
        String[] a = {"Ram","Sita","Laxman","Ram","Ram"};
        
        Map<String,Integer> hm = new HashMap<>();
        Arrays.stream(a).forEach(x-> {
            int i = hm.computeIfAbsent(x, s -> 1) + 1;
        });
    }

}
