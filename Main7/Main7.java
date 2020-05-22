import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.URL;
import java.util.concurrent.Executors;

import com.sun.net.httpserver.*;

class MyHandler implements HttpHandler {
    @Override
    public void handle(final HttpExchange exchange) throws IOException {
        if (!exchange.getRequestMethod().equals("GET")) {
            System.out.print("Not a get: ");
            System.out.println(exchange.getRequestMethod());
            exchange.sendResponseHeaders(400, 0);
            exchange.getResponseBody().close();
            return;
        }

        final Headers headers = exchange.getRequestHeaders();

        String host = "";
        for (final String header : headers.keySet()) {
            if (header.equalsIgnoreCase("host")) {
                host = headers.getFirst(header);
            }
        }
        if (host.equals("")) {
            System.out.println("Host is empty");
            exchange.sendResponseHeaders(400, 0);
            exchange.getResponseBody().close();
            return;
        }

        System.out.print("Fetching ");
        System.out.print(host);
        System.out.println(exchange.getRequestURI());

        // Lol, https
        final var url = new URL("https://" + host + exchange.getRequestURI());

        final var connection = (HttpURLConnection) url.openConnection();

        exchange.sendResponseHeaders(connection.getResponseCode(), 0);

        final var inputStream = connection.getInputStream();

        final var outputStream = exchange.getResponseBody();

        final int BUF_LEN = 4096;
        byte[] buf = new byte[BUF_LEN];

        while (true) {
            int len = inputStream.read(buf, 0, buf.length);
            if (len <= 0) {
                break;
            }
            outputStream.write(buf, 0, len);
        }

        outputStream.close();
        inputStream.close();

        System.out.println("Request is done");
    }
}

public class Main7 {

    public static void main(final String[] args) throws IOException {
        final var s = HttpServer.create(new InetSocketAddress(8080), 0);

        s.createContext("/", new MyHandler());
        s.setExecutor(Executors.newFixedThreadPool(30));

        s.start();
        System.out.println("Started");

    }
}
