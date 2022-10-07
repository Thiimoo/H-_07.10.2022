import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Input chunks:");
        int chunks = s.nextInt();
        System.out.println("Input divider:");
        int divider = s.nextInt();
        ConcurrencyNumbers cn = new ConcurrencyNumbers();
        List<Integer> integerList = cn.readFile();

        ExecutorService executor = Executors. newFixedThreadPool(chunks);
        int counter = 100;
        for (int i = 0; i < chunks; i++) {
            Future<List<Integer>> result = executor.submit(new Task(counter,integerList,divider));
            try {
                printList(result.get());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (ExecutionException e) {
                throw new RuntimeException(e);
            }
            counter = counter +100;
        }
        executor.shutdown();
        System.out.println("Input n:");
        int n = s.nextInt();

        ExecutorService executorSum = Executors. newFixedThreadPool(n);
        int sum = 0;
        int counter2 = 100;
        for (int i = 0; i < n; i++) {
            Future<Integer> result = executorSum.submit(new Sumtask(counter2,integerList));
            try {
                sum = sum+ result.get();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (ExecutionException e) {
                throw new RuntimeException(e);
            }
            counter2 = counter2 +100;
        }
        System.out.println(sum);
        System.exit(0);
    }

    public static void printList(List<Integer> list)
    {
        list.forEach(System.out::println);
    }

}
