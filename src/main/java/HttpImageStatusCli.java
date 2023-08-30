import java.util.Scanner;

public class HttpImageStatusCli {
    void askStatus() throws Exception {
        HttpStatusImageDownloader httpStatusImageDownloader = new HttpStatusImageDownloader();

        Scanner in = new Scanner(System.in);
        boolean hasNextInt;

        do {
            System.out.print("Enter HTTP status code ");

            hasNextInt = in.hasNextInt();
            if (hasNextInt) {
                int codeInput = in.nextInt();
                try {
                    httpStatusImageDownloader.downloadStatusImage(codeInput);
                } catch (ImageNotFoundException e) {
                    System.err.println(e.getMessage());
                    Thread.sleep(10);
                    hasNextInt=false;
                }
            } else {
                in.nextLine();
            }
        } while (!hasNextInt);
        in.close();
    }
}
