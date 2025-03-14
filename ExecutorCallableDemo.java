import java.util.Optional;
import java.util.concurrent.*;

public class ExecutorCallableDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService ex = Executors.newFixedThreadPool(3);
        Future<Integer> sumResult=ex.submit(new Sum(10));
        Future<Double> sqrRootResult= ex.submit(new SquareRoot(16));
        Future<Integer> factResult= ex.submit(new FactorialDemo(5));

        System.out.println("Started Processing...!!!");
        System.out.println("Sum Result  : "+ sumResult.get());
        System.out.println("sqrRoot Result  : "+ sqrRootResult.get());
        System.out.println("Factorial Result  : "+ factResult.get());
        ex.shutdown();
        System.out.println("Completed Processing...!!!");
    }
}


class Sum implements Callable<Integer> {

    int stop;

    Sum(int no) {
        stop = no;
    }

    public Integer call() {
        int result = 0;
        for (int i = 0; i < stop; i++) {
            result = result + i;
        }
        return result;
    }
}

class SquareRoot implements Callable<Double> {
    int num;

    SquareRoot(int no) {
        num = no;
    }

    public Double call() {

        return Math.sqrt(num);
    }
}

class FactorialDemo implements Callable<Integer> {

    int fact = 1;
    int num;

    FactorialDemo(int no) {
        num = no;
    }

    @Override
    public Integer call() throws Exception {
        for (int i = 2; i < num; i++) {
            fact = fact * i;
        }
        return fact;
    }
}