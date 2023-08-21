import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.zip.*;


public class GameProgress implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private int health;
    private int weapons;
    private int lvl;
    private double distance;

    public GameProgress(int health, int weapons, int lvl, double distance) {
        this.health = health;
        this.weapons = weapons;
        this.lvl = lvl;
        this.distance = distance;
    }

    @Override
    public String toString() {
        return "GameProgress{" +
                "health=" + health +
                ", weapons=" + weapons +
                ", lvl=" + lvl +
                ", distance=" + distance +
                '}';
    }

    public static void saveGame(String way, GameProgress progress){

        GameProgress gameProgress = progress;

        try (FileOutputStream fos = new FileOutputStream("C:/Users/foox2/IdeaProjects/Games/savegames/"
                + way); //название указать проще чем полный путь
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {

            oos.writeObject(gameProgress);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void zipFiles(String zip, String way){
        try (ZipOutputStream zout = new ZipOutputStream(new
                FileOutputStream("C:/Users/foox2/IdeaProjects/Games/savegames/"
                + zip));
             FileInputStream fis = new FileInputStream("C:/Users/foox2/IdeaProjects/Games/savegames/"
                     + way)) {
            ZipEntry entry = new ZipEntry(way);
            zout.putNextEntry(entry);
            byte[] buffer = new byte[fis.available()];
            fis.read(buffer);
            zout.write(buffer);
            zout.closeEntry();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        try {
            Files.delete(Path.of("C:/Users/foox2/IdeaProjects/Games/savegames/"
                    + way));
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }

}
}
