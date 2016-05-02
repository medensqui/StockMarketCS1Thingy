import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

import org.dalton.DaltonStock;

/**
 *
 */

/**
 * @author student
 *
 */
public class Stock {

	/**
	 * @param args
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) throws FileNotFoundException,
			UnsupportedEncodingException {
		// TODO Auto-generated method stub
		double money = 2000;
		int shares = 0;
		String choice = "";
		String stockz = "";
		String stock1 = "";
		String stock2 = "";
		String stock3 = "";
		String stock4 = "";
		String stockp1 = "";
		int shares1 = 0;
		Scanner input = new Scanner(System.in);

		while (money > 0) {
			if (money == 1) {
				System.out.println("You have 1 dollar.");
			} else {
				System.out.println("You have " + money + " dollars.");
			}

			System.out
					.println("Would you like to buy, sell, or check prices? Type B for buy, S for sell, and P for prices.");
			choice = input.nextLine();

			if (choice.equals("P")) {
				System.out.println("What stock would you like to check?");
				stockp1 = input.nextLine();
				DaltonStock stockp11 = new DaltonStock(stockp1);
				System.out.println(stockp11.lastprice);
			} else if (choice.equals("B")) {
				System.out.println("What stock would you like to buy?");
				stock1 = input.nextLine();
				DaltonStock stock = new DaltonStock(stock1);
				System.out.println("How many shares would you like to buy?");
				shares = input.nextInt();
				money = money - stock.lastprice * shares;
				PrintWriter writer = new PrintWriter("stockssave.txt", "UTF-8");
				writer.println(stock1 + "," + shares);
				writer.close();

				if (stock1.equals("")) {
					stock1 = stock.symbol;
					shares1 = shares;
					System.out.println(stock1);
					System.out.println(shares1);
				} else if (choice.equals("S")) {

				}
			}
		}
	}
}
