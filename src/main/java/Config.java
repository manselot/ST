import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class Config {
    public static void  changeConfigArea(String text) {
        String[] aboba = Config.setConfig();
        try {
            File f = new File("src/main/resources/ñonfig.txt");
            FileWriter writer = new FileWriter(f, false);
            writer.write(text + ";" + aboba[1]);
            writer.flush();
        } catch (Exception e) {
            System.err.println(e);
        }
    }
    public static void  changeConfigTrans(String text) {
        String[] aboba = Config.setConfig();
        try {
            File f = new File("src/main/resources/ñonfig.txt");
            FileWriter writer = new FileWriter(f, false);
            writer.write(aboba[0] + ";" + text);
            writer.flush();
        } catch (Exception e) {
            System.err.println(e);
        }
    }
    public static String[] setConfig() {
        String res = "";
        File f = new File("src/main/resources/ñonfig.txt");
        try {
            FileReader tfr = new FileReader(f);
            int c;
            while((c= tfr.read())!=-1){
                res += (char)c;
            }
            String[] aboba = res.split(";");
            return aboba;
        }catch (Exception e) {
            System.err.println(e);
        }
        return null;
    }
    public static void readConfig() {
        String res = "";
        try {
            File f = new File("src/main/resources/ñonfig.txt");
            if (!f.exists()) {
                f.createNewFile();
                FileWriter writer = new FileWriter(f, false);
                String con = "m;n";
                writer.write(con);
                writer.close();
            }
        }
        catch (Exception e) {
            System.err.println(e);
        }
    }
}

