package self.ed;

import java.nio.file.Paths;

import static spark.Spark.get;
import static spark.Spark.staticFiles;

public class Server {
    public static void main(String[] args) {
        staticFiles.location("/public");
        staticFiles.externalLocation(Paths.get("applet", "out", "production", "classes").toAbsolutePath().toString());
        get("/test", ((request, response) -> "Test!"));
    }
}
