import java.util.Scanner;
public class switchCase {
public static void main (String[] args)
{
	Scanner userInput = new Scanner(System.in);
	String sale;
	double price;
	double discount;
	double disAmount;
	double pricePaid;
	System.out.println("Does the store has sale");
	sale = userInput.next();
	if (sale.equalsIgnoreCase("yes"))
	{
		System.out.println("We will go for shopping");
		System.out.println("Enter price you spent");
		price = userInput.nextDouble();
		if (price >= 500)
		{
			discount = .5;	
		}
		else if (price >99 )
		{
			discount = 0.4;
		}
		else if (price > 49)
		{
			discount = .2;	
		}
		else if (price >9)
		{
			discount = 0.1;
		}
		else
		{
			discount = 0;
		}
		disAmount = price * discount;
		pricePaid = price - disAmount;
		System.out.println("You paid "+ pricePaid + " after discount.");
	}
	else
	{
		System.out.println("Sorry No shopping");
	}
	System.out.println("What is numeric day today");
	int day = userInput.nextInt();
	String today;
	switch (day)
	{
	case 1 :  
		today = "Monday";
		break;
	case 2:
		today = "Tuesday";
		break;
	case 3 :  
		today = "Wednesday";
		break;
	case 4:
		today = "Thursday";
		break;
	case 5 :  
		today = "Friday";
		break;
	case 6:
		today = "Saturday";
		break;
	case 7 :  
		today = "Sunday";
		break;
		default:
			today = "Invalid Day";
			break;
		
	}
	System.out.println(today);
}
}
