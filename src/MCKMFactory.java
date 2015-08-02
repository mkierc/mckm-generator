import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MCKMFactory {
    public static String getMCKMWord(long seed) {
        List<String> mckmList = new ArrayList<>();
        mckmList.add("znakomicie");
        mckmList.add("wyśmienicie");
        mckmList.add("świetnie");
        mckmList.add("prześwietnie");
        mckmList.add("pierwszorzędnie");
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
        mckmList.add("nieprzeciętnie");
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
