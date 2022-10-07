import javax.security.auth.callback.Callback;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class Task implements Callable<List<Integer>> {

    private int teiler;
    private int limit;
    private List<Integer> integerList;

    public Task(int bereich, List<Integer> integerList, int teiler)
    {
        this.limit = bereich;
        this.integerList = integerList;
        this.teiler = teiler;
    }

    @Override
    public List<Integer> call() throws Exception {
        List<Integer> returnlist = new ArrayList<>();
        for (int i = limit-100; i < limit; i++) {
            if (integerList.get(i) % teiler == 0)
            {
                returnlist.add(integerList.get(i));
            }
        }
        return returnlist;
    }
}
