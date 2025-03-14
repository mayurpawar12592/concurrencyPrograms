import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorRunnable {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService= Executors.newSingleThreadExecutor();
        Runnable task =()->{
            System.out.println("Waiting");
            try {
                Thread.sleep(2000);
                System.out.println("Waiting completed");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };
       Future<?> result= executorService.submit(task);
       result.get();
        System.out.println("Task completed");
        executorService.shutdown();
    }
}
