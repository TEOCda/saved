import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class Main {
    public static void main(String[] args) {

        GameProgress f1 = new GameProgress(100, 50, 90, 5.9);
        GameProgress f2 = new GameProgress(10, 150, 910, 15.9);
        GameProgress f3 = new GameProgress(1050, 550, 590, 45.9);

        GameProgress.saveGame("save1.dat", f1);
        GameProgress.saveGame("save2.dat", f2);
        GameProgress.saveGame("save3.dat", f3);
        GameProgress.zipFiles("Zip1.zip", "save1.dat");
        GameProgress.zipFiles("Zip2.zip", "save2.dat");
        GameProgress.zipFiles("Zip3.zip", "save3.dat");


    }


}
