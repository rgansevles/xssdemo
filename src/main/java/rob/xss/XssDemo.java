package rob.xss;
import static spark.Spark.*;

public class XssDemo {

	public static void main(String[] args) {
		get("/xssdemo", (req, res) -> {
			res.header("Content-Security-Policy", "script-src 'self'");
			return "<html></body>"+getMessage(args)+"<html></body>";
		});
	}

	private static String getMessage(String[] args) {
		if (args == null || args.length == 0) {
			return "??";
		}
		
		return args[0];
	}

}
