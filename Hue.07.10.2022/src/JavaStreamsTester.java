import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class JavaStreamsTester {

    private static List<String> stringList = new ArrayList<>();
    private static List<Integer> intsList = new ArrayList<>();

    public static void main(String[] args) {
        stringList.add("yes");
        stringList.add("no");
        stringList.add("Hello");
        stringList.add("");
        stringList.add("help");
        stringList.add("");
        System.out.println("stringsList:");
        stringList.forEach(System.out::println);
        System.out.println("\n");

        System.out.println("empty Strings:");
        System.out.println(getCountEmptyString());
        System.out.println("\n");
        System.out.println("Strings with lenght 3 or less:");
        System.out.println(getCountLength3());
        System.out.println("\n");
        System.out.println("without empty Strings:");
        deleteEmptyStrings().forEach(System.out::println);
        System.out.println("\n");
        System.out.println("merged Strings:");
        System.out.println(getMergedString(";"));
        System.out.println("\n");

        intsList.add(1);
        intsList.add(2);
        intsList.add(3);
        intsList.add(4);
        intsList.add(5);
        System.out.println("intsList:");
        intsList.forEach(System.out::println);
        System.out.println("\n");

        System.out.println("squared ints:");
        getSquares().forEach(System.out::println);
        System.out.println("\n");
        System.out.println("maximum:");
        System.out.println(getMax());
        System.out.println("\n");
        System.out.println("minimum:");
        System.out.println(getMin());
        System.out.println("\n");
        System.out.println("sum:");
        System.out.println(getSum());
        System.out.println("\n");
        System.out.println("average:");
        System.out.println(getAverage());
        System.out.println("\n");
    }

    private static int getCountEmptyString()
    {
        return (int) stringList.stream().filter(m -> m.isEmpty()).count();
    }

    private static int getCountLength3()
    {
        return (int) stringList.stream().filter(m -> m.length()<=3).count();
    }

    private static List<String> deleteEmptyStrings()
    {
        stringList.removeIf(String::isEmpty);
        return stringList;
    }

    private static String getMergedString(String separator)
    {
        String result = stringList.stream().collect(Collectors.joining(separator));
        return result;
    }

    private static List<Integer> getSquares()
    {
        return intsList.stream().map(m->m*m).toList();
    }

    private static int getMax()
    {
        return intsList.stream().mapToInt(m -> m).max().orElseThrow(NoSuchElementException::new);
    }

    private static int getMin()
    {
        return intsList.stream().mapToInt(m -> m).min().orElseThrow(NoSuchElementException::new);
    }
    private static int getSum()
    {
        return intsList.stream().mapToInt(m -> m).sum();
    }
    private static int getAverage()
    {
        int[] array = new int[intsList.size()];
        for(int i = 0; i < intsList.size(); i++) array[i] = intsList.get(i);
        IntStream stream = Arrays.stream(array);
        return (int) stream.average().getAsDouble();
    }

}
