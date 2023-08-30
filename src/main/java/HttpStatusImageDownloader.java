import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

public class HttpStatusImageDownloader {
    void downloadStatusImage(int code) throws Exception {

        HttpStatusChecker httpStatusChecker = new HttpStatusChecker();
        String imagHttp = httpStatusChecker.getStatusImage(code);

        if (imagHttp.equals("404")) {
            throw new ImageNotFoundException("There is not image for HTTP status " + code);
        }

        String fileName = "CatCod_" + code + ".jpg";
        File outputFile = new File(fileName);

        try (InputStream in = new URL(imagHttp).openStream();
             OutputStream out = new FileOutputStream(outputFile)) {
            byte[] b = new byte[2048];
            int length;
            while ((length = in.read(b)) != -1) {
                out.write(b, 0, length);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}