import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class MCKMUtils {
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

    public static Map<String, String> readSettings() {
        Map<String, String> settingsMap = new HashMap<>();
        try {
            Scanner inScanner;
            inScanner = new Scanner(new FileReader("settings.dat"));
            String style = inScanner.nextLine();
            if ("DARK".equals(style))
                settingsMap.put("style", "com.bulenkov.darcula.DarculaLaf");
            else
                settingsMap.put("style", "com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            settingsMap.put("xpos", inScanner.nextLine());
            settingsMap.put("ypos", inScanner.nextLine());

        } catch (Exception e) {
            e.printStackTrace();
        }
        return settingsMap;
    }

    public static void writeSettings(Map<String, String> settings) {
        try {
            File outputFile = new File("settings.dat");
            FileWriter fw = new FileWriter(outputFile);

            String style = settings.get("style");
            if ("com.bulenkov.darcula.DarculaLaf".equals(style))
                fw.write("DARK\n");
            else
                fw.write("BRIGHT\n");
            fw.write(settings.get("xpos") + "\n");
            fw.write(settings.get("ypos") + "\n");
            fw.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
