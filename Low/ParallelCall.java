import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ParallelCall {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ParallelCall parallelCall = new ParallelCall();
        ExecutorService executor = Executors.newFixedThreadPool(3);
        Future<String> ans1 = executor.submit(parallelCall::method1);
        Future<String> ans2future = executor.submit(() -> parallelCall.method2(ans1.get()));
        Future<String> ans3future = executor.submit(() -> parallelCall.method3(ans1.get()));

        parallelCall.method4(ans2future.get(), ans3future.get());
        executor.close();
    }

    private String method1(){
        return "I am Awesome1 ";
    }


    private String method2(String ans1){
        return ans1+ "I am Awesome2";
    }


    private String method3(String ans1){
        return ans1+ "I am Awesome3";
    }


    private void method4(String s1, String s2){
        System.out.println("String s1 is "+s1);
        System.out.println("String s2 is "+s2);
    }


}
