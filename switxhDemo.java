import java.util.Scanner;
public class switxhDemo {
	public static void main (String[] args)
	{
		Scanner userInput = new Scanner(System.in);
		String browser;
		String message;
		System.out.println("Please enter a browser");
		browser = userInput.nextLine();
		switch(browser)
		{
		case "safari" : 
			message = "Your code will be executed on Safari Browser";
			break;
		case "chrome":
			message = "Your code will be executed on Chrome Browser";
			break;
		case "firefox":
			message = "Your code will be executed on Firefox Browser";
			break;
		default:
			message = "Entered browser is not supported";
				
		}
		System.out.println(message);
	}

}
