import java.io.*;
import java.net.*;
import com.sun.net.httpserver.*;

public class HelloWorld {
    public static void main(String[] args) throws Exception {
        // Create HTTP server
        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);
        server.createContext("/", new HttpHandler() {
            @Override
            public void handle(HttpExchange exchange) throws IOException {
                String response = "Hello, World from Dockerized Java App!";
                exchange.sendResponseHeaders(200, response.getBytes().length);
                OutputStream os = exchange.getResponseBody();
                os.write(response.getBytes());
                os.close();
            }
        });

        // Start server
        server.start();
        System.out.println("Server is listening on port 8080...");
    }
}
