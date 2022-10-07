import java.util.List;
import java.util.concurrent.Callable;

public class Sumtask implements Callable<Integer> {

    private int limit;
    private List<Integer> integerList;

    public Sumtask(int bereich, List<Integer> integerList)
    {
        this.limit = bereich;
        this.integerList = integerList;
    }

    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for (int i = limit-100; i < limit; i++) {
            sum = sum+ integerList.get(i);
        }
        return sum;
    }
}
