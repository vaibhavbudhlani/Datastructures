package SelfPractice;

/**
 *  Equilibrium point is one from which left hand side sum is same as right hand side sum.
 *  Ex n = 5
 * A[] = {1,3,5,2,2}
 * Output:
 * 3
 *
 * n = 1
 * A[] = {1}
 * Output:
 * 1
 */
public class EquilibriumPoint {
    public static void main(String[] args) {
        int[] a = {1,3,7,2,11};
        int tsum = 0;
        int lsum = 0;
        for (int j : a) {
            tsum += j;
        }
        System.out.println(tsum);
        for(int i=0;i<a.length;i++){

            if(lsum == (tsum - a[i])){
                System.out.println(i);
                break;
            }
            lsum += a[i];
            tsum = tsum - a[i];
        }

    }
}

/**
 *
 */
