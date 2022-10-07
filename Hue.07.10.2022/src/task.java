import java.util.List;

public class task implements Runnable{

    private int teiler;
    private int limit;
    private List<Integer> integerList;

    public task(int bereich,List<Integer> integerList,int teiler)
    {
        this.limit = bereich;
        this.integerList = integerList;
        this.teiler = teiler;
    }

    @Override
    public void run() {
        for (int i = limit-100; i < limit; i++) {
            if (integerList.get(i) % teiler == 0)
            {
                System.out.println(integerList.get(i));
            }
        }
    }
}
