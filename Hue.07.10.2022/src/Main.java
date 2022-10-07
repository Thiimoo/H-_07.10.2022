import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

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
            executor.execute(new task(counter,integerList,divider));
            counter = counter +100;
        }

    }

}
