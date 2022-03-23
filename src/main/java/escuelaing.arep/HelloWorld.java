package escuelaing.arep;

import static spark.Spark.*;
public class HelloWorld {
    public static void main(String[] args) {
        secure(getCertificates(), "pulido", null, null);
        port(getPort());
        get("/hello", (req, res) -> "Hello World");
    }
    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 5000; //returns default port if heroku-port isn't set (i.e. on localhost)
    }
    static String getCertificates() {
        if (System.getenv("Certificates") != null) {
            return System.getenv("Certificates");
        }
        return "keystores/ecikeystore.p12"; //returns default port if heroku-port isn't set (i.e. on localhost)
    }
}