import javax.swing.JOptionPane;
public class Program {
	public static void main(String[] args)
	{
		//declare variables
		//set (!done) loop
		//{ get flag from user if flag=1 get card number 
		//from user validateCard() else if flag=2 get account num 
		//from user calculateCheckDigit() else done = true
		String flag_string;
		boolean done = false;
		String card_string;
		String account_string = "";
		long card_num; 
		int length = 0;
		long acct_num;
		long new_acct_num;
		boolean valid = false;
		int check_digit;
		while (!done)
		{
			int flag = 0;
			flag_string = JOptionPane.showInputDialog("Enter 0 to quit; "
					+ "\n Enter 1 to validate credit card number; "
					+ "\n Enter 2 to calculate the check digit for an account number"
					+ "\n Enter 3 if you want to know any numbers of your credit card");
			flag = Integer.parseInt(flag_string);
		//flag to help user input either credit card number or account num	
			if (flag==1)
			{
				card_string = JOptionPane.showInputDialog("Please enter 16 digit card number");
				length = card_string.length();
				;
				//validatecard and card length to make sure user enters only 16 digits
				if (length == 16) 
				{
					card_num = Long.parseLong(card_string);
					valid = validateCard(card_num);
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Data entry error \n"
							+ " Invalid card Number Length: length = " + length);
				}

			}
			else if (flag == 2)
			{
				// get account number from user to make sure user enters only 15 digits
				account_string = JOptionPane.showInputDialog("Enter 15 digit account number");
				length = account_string.length();
				//calculateCheckDigit()
				if (length == 15) 
				{
					acct_num =  Long.parseLong(account_string);
					new_acct_num = acct_num *10;
					check_digit = calculateCheckDigit (new_acct_num);
					JOptionPane.showMessageDialog(null, "Check Digit = " + check_digit);

				}
				else
				{
					JOptionPane.showMessageDialog(null, "Data entry error \n"
							+ " Invalid Account Number Length: length = " + length);
				}
			}
			else
			{
				System.out.println(valid);
				done = true;
			}
		}
	}
	public static boolean validateCard (long card_num)
	{
		// moving from left to right to calculate the sum of even digit (reading from left to right) and 
		int even = 0;
		int sumTotal;
		int deductedPoint;
		int checkPoint;
		long checkPointForCard;
		int odd = 0;
		even = sumEven(card_num);
		//JOptionPane.showMessageDialog(null,  "Method sumEven returned " + even);
		odd = sumOdd (card_num);
		//JOptionPane.showMessageDialog(null,  "Method sumOdd returned " + odd);
		//I did this at home
		// sum of odd digit (reading from left to right)
		// total of two sum
		// calculate correct check digit
		// compare calculated check digit to the actual check digit
		// if they are equal return false
		sumTotal = odd + even;
		deductedPoint = ((sumTotal/10)+1)*10;
		checkPoint = deductedPoint - sumTotal;
		checkPoint = checkPoint%10;
		checkPointForCard = (card_num%10);
		if (checkPoint == checkPointForCard)
		{
			JOptionPane.showMessageDialog(null,  "Card number is valid");
		}
		else
		{
			
			JOptionPane.showMessageDialog(null,  "You Entered an invalid card number ");
		}
		return true;
	}

	public static int sumEven (long card_num)
	{
		// moving from left to right to calculate the sum of even digit (reading from left to right) and 
		int sum= 0;
		long numbers = card_num;
		long new_card_num;
		new_card_num = numbers /100;
		for (int i = 0; i<16; i++)
		{
			sum += new_card_num % 10;
			new_card_num = new_card_num /100;
		}
		//JOptionPane.showMessageDialog(null,  "sumEven returns " + sum);

		// sum of odd digit (reading from left to right)
		// total of two sum
		// calculate correct check digit
		// compare calculated check digit to the actual check digit
		// if they are equal return false

		return sum;
	}
	public static int sumOdd (long card_num)
	{
		int sum=0;
		long multiply = 0;
		//declare two int to hold mod and div value sum
		int divValueSum=0, modValueSum=0;
		long oddSum = 0;
		long numbers = card_num;
		long new_odd_num;
		new_odd_num = numbers/10;
		for (int i=0; i<16; i++)
		{
			oddSum = new_odd_num % 10;
			multiply = (2*oddSum);
			divValueSum+=  multiply/10;
			modValueSum+= multiply%10;
			new_odd_num = new_odd_num / 100;
		}
		sum = divValueSum + modValueSum;
		return sum;
	}
	public static int calculateCheckDigit (long acct_num)
	{
		int even = 0;
		int sumTotal;
		int deductedPoint;
		int checkPoint;
		int odd = 0;
		odd = sumOdd (acct_num);
		even = sumEven(acct_num);

		//JOptionPane.showMessageDialog(null,  "Method sumEven returned " + even);
		//JOptionPane.showMessageDialog(null,  "Method sumOdd returned " + odd);

		sumTotal = odd + even;
		deductedPoint = ((sumTotal/10)+1)*10;;
		checkPoint = deductedPoint - sumTotal;
		checkPoint = checkPoint%10;
		return checkPoint;
	}
}

