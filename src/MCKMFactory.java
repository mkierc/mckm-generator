import java.util.*;

public class MCKMFactory {
    public static String getMCKMWord() {
        // Backwards compatibility with deprecated java.util.Date.getYear()
        int year = Calendar.getInstance().get(Calendar.YEAR) - 1900;
        int month = Calendar.getInstance().get(Calendar.MONTH);
        // Backwards compatibility with deprecated java.util.Date.getDay()
        int day = Calendar.getInstance().get(Calendar.DAY_OF_WEEK) - 1;

        long seed = year + month + day * 31;
        return generateWord(seed);
    }

    public static String generateWord(long seed) {
        List<String> mckmList = new ArrayList<>();
        mckmList.add("znakomicie");
        mckmList.add("wyœmienicie");
        mckmList.add("œwietnie");
        mckmList.add("przeœwietnie");
        mckmList.add("pierwszorzêdnie");
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
        mckmList.add("nieprzeciêtnie");
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
