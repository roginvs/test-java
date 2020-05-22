import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Client {
    public static void main(final String[] args) throws IOException {
        System.out.println("Use me this way:");
        System.out.println("java Client.java https://spacerangers.gitlab.io/index.html localhost 8080");

        System.out.println("");

        System.setProperty("sun.net.http.allowRestrictedHeaders", "true");

        final var url = new URL(args[0]);

        final var proxyUrl = new URL("http://" + args[1] + ":" + args[2] + url.getPath());

        final var connection = (HttpURLConnection) proxyUrl.openConnection();

        connection.setRequestProperty("host", url.getHost());

        final var inputStream = connection.getInputStream();
        BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));
        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            System.out.println(inputLine);
        }
        in.close();

    }
}