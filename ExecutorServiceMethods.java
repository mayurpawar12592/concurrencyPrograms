import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceMethods {
    public static void main(String[] args) throws InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        System.out.println("===================================invokeAll()=======================================");
        Callable<Integer> callable1 = () -> {
            System.out.println("Callable task 1");
            return 1;
        };

        Callable<Integer> callable2 = () -> {
            System.out.println("Callable Task 2");
            return 2;
        };

        Callable<Integer> callable3 = () -> {
            System.out.println("Callable Task 3");
            return 3;
        };

        List<Callable<Integer>> listOfCallableTask = Arrays.asList(callable1, callable2, callable3);

        executorService.invokeAll(listOfCallableTask);
        executorService.shutdown();


        System.out.println("===================================InvokeAny()=======================================");
        ExecutorService executorService1 = Executors.newSingleThreadExecutor();
        try {
            executorService1.invokeAny(listOfCallableTask);
            executorService1.shutdown();
        } catch (ExecutionException ex) {
           //Exception
        }
    }
}
