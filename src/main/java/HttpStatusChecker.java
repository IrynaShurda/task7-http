import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;

import java.io.IOException;

public class HttpStatusChecker {
    String getStatusImage(int code) throws IOException {

        String url = "https://http.cat/" + code + ".jpg";

        try {
            Jsoup.connect(url)
                    .ignoreContentType(true)
                    .get();
        } catch (HttpStatusException e) {
            url = String.valueOf(e.getStatusCode());
        }
        return url;

    }
}
