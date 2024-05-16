package SelfPractice;

import java.util.Arrays;

public class MonoLearning {
    public static void main(String[] args) {
       // Mono<String> mono = Mono.j
        System.out.println(maxSatisfaction(new int[]{-1,-8,0,5,-9}));
    }

    public static  int maxSatisfaction(int[] satisfaction) {

        Arrays.sort(satisfaction);
        int sum = 0, tot = 0, maxi = 0;

        for(int i = satisfaction.length - 1; i >= 0 && sum >= 0; --i){
            tot += sum + satisfaction[i];
            sum += satisfaction[i];
            if( tot > maxi) maxi = tot;
        }

        return maxi;

    }
}
