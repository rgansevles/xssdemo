package rob.xss;
import static spark.Spark.get;

import org.owasp.html.PolicyFactory;
import org.owasp.html.Sanitizers;


public class XssDemo {

	public static void main(String[] args) {
		get("/xssdemo", (req, res) -> "<html></body>"+getMessage(args)+"<html></body>");
	}

	private static String getMessage(String[] args) {
		if (args == null || args.length == 0) {
			return "??";
		}
		
		PolicyFactory policy = Sanitizers.FORMATTING.and(Sanitizers.LINKS);
		return policy.sanitize(args[0]);
	}

}
