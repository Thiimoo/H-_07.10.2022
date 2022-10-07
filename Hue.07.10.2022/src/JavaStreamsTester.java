import java.util.ArrayList;
import java.util.List;

public class JavaStreamsTester {

    private static List<String> stringList = new ArrayList<>();

    public static void main(String[] args) {
        stringList.add("yes");
        stringList.add("no");
        stringList.add("Hello");
        stringList.add("");
        stringList.add("help");
        stringList.add("");
        System.out.println("List:");
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

}
