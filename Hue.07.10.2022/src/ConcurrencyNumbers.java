import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConcurrencyNumbers {

    public List<Integer> readFile()
    {
        String line;
        String[] parts;
        List<Integer> integerList = new ArrayList<>();
        try{
            Scanner s = new Scanner(new File("src/numbers.csv"));
            while (s.hasNextLine())
            {
                line = s.nextLine();
                parts = line.split(":");
                for (int i = 0; i < parts.length; i++) {
                    if (parts[i] != null)
                    {
                        if (isNumeric(parts[i]))
                        {
                            integerList.add(Integer.parseInt(parts[i]));
                        }
                    }
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return integerList;
    }

    public static boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }
}
