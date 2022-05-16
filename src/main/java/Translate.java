import java.io.File;
import java.io.UnsupportedEncodingException;

import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

public class Translate {
    public static String translate() throws TesseractException, InterruptedException, UnsupportedEncodingException {
        File image = new File("C:\\Users\\abuzer\\Desktop\\screenshot.png");
        Tesseract tesseract = new Tesseract();
        tesseract.setDatapath("C:\\Users\\abuzer\\Desktop\\tessdata-4.1.0");
        tesseract.setLanguage("eng");
        tesseract.setPageSegMode(1);
        tesseract.setOcrEngineMode(1);
        String result = tesseract.doOCR(image);
        return ParseTranslate.parse(result);
    }
}
