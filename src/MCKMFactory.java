import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MCKMFactory {
    public static String getMCKMWord(long seed) {
        List<String> mckmList = new ArrayList<>();
        mckmList.add("znakomicie");
        mckmList.add("wy�mienicie");
        mckmList.add("�wietnie");
        mckmList.add("prze�wietnie");
        mckmList.add("pierwszorz�dnie");
        mckmList.add("wybornie");
        mckmList.add("przewybornie");
        mckmList.add("idealnie");
        mckmList.add("fantastycznie");
        mckmList.add("genialnie");
        mckmList.add("wspaniale");
        mckmList.add("przednio");
        mckmList.add("perfekcyjnie");
        mckmList.add("fenomenalnie");
        mckmList.add("rewelacyjnie");
        mckmList.add("kapitalnie");
        mckmList.add("bosko");
        mckmList.add("cudownie");
        mckmList.add("wzorowo");
        mckmList.add("bezkonkurencyjnie");
        mckmList.add("nadzwyczajnie");
        mckmList.add("wyborowo");
        mckmList.add("mistrzowsko");
        mckmList.add("nieprzeci�tnie");
        mckmList.add("setnie");
        mckmList.add("znakomicie");
        Random random;
        if (seed != 0)
            random = new Random(seed);
        else
            random = new Random();
        return mckmList.get(random.nextInt(mckmList.size()));
    }
}
