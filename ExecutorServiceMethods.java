import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class ExecutorServiceMethods {
    public static void main(String[] args) throws InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        System.out.println("===================================invokeAll()=======================================");
        Callable<Integer> callable1 = () -> {
            System.out.println("Callable task 1");
            return 1;
        };

        Callable<Integer> callable2 = () -> {
            Thread.sleep(1000);
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
           Integer result = executorService1.invokeAny(listOfCallableTask, 1, TimeUnit.MILLISECONDS);
            System.out.println("Result :"+result);
            executorService1.shutdown();
        }catch (TimeoutException ex){
            //TimeoutException Exception
        } catch (ExecutionException ex) {
           //Exception
        }
        System.out.println("===================================Future.get(),isDone(),isComplete()=======================================");
        ExecutorService service =Executors.newSingleThreadExecutor();
        Future<Integer> future = service.submit(()->{
            try {
                System.out.println("task started");
                Thread.sleep(2000);

            }catch(InterruptedException e){
                System.out.println("task InterruptedException");
            }
            System.out.println("task completed");
            return 12;
        });
        try {
            //int i = future.get(1, TimeUnit.SECONDS);
         //   System.out.println("i:- " + i);
            Thread.sleep(1000);
            future.cancel(false);
            System.out.println("isDone:- " + future.isDone());
            System.out.println("iSCancelled:- " + future.isCancelled());
//        }catch (TimeoutException e) {
//            throw new RuntimeException(e);
//        } catch (ExecutionException e) {
//            throw new RuntimeException(e);
//        }
        }catch(InterruptedException e){
            //
        }
        service.shutdown();

    }
}
