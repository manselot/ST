import java.io.File;
import java.io.IOException;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

public class Translate {
    public static String translate() throws TesseractException, InterruptedException, IOException {
        File image = new File("src/main/resources/screenshot.png");
        Tesseract tesseract = new Tesseract();
        tesseract.setDatapath("src/main/resources/tessdata-4.1.0");
        tesseract.setLanguage("eng");
        tesseract.setPageSegMode(1);
        tesseract.setOcrEngineMode(1);
        String result = tesseract.doOCR(image);
        return ParseTranslate.parse(result);
    }
}
