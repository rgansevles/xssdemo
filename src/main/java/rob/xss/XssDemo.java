package rob.xss;
import static spark.Spark.get;

import org.owasp.encoder.Encode;

public class XssDemo {

	public static void main(String[] args) {
		get("/xssdemo", (req, res) -> "<html></body>"+getMessage(args)+"<html></body>");
	}

	private static String getMessage(String[] args) {
		if (args == null || args.length == 0) {
			return "??";
		}

		return Encode.forHtml(args[0]);
	}

}
