package IMT_HearStone;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class Logger {

    private static PrintStream originalOut = System.out;
    private static PrintStream fileOut;

    static {
        try {
            // Spécification du fichier dans lequel vous voulez écrire le log
            FileOutputStream fileOutputStream = new FileOutputStream("log.txt");
            fileOut = new PrintStream(fileOutputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static void log(String message) {
        // Écriture dans le fichier
        fileOut.println(message);

        // Affichage dans le terminal
        originalOut.println(message);
    }

    public static void close() {
        // Fermer le flux vers le fichier
        fileOut.close();
    }
}