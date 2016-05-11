import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;
import java.sql.*;

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
		String answer1 = "";
		String answer2 = "";
		int sellshares = 0;
		int shares1 = 0;
		int shares2 = 0;
		double buyprice1 = 0;
		double buyprice2 = 0;
		String username = "";
		Scanner input = new Scanner(System.in);

		System.out.println("What is your username?");
		username = input.nextLine();

		String db = "jdbc:mysql://cs1.cjrt1qdbts5p.us-west-2.rds.amazonaws.com:3306/Test";
		String usernamedb = "root";
		String pwddb = "daltoncs1";

		try {
			// Connect to database
			System.out.println("Connecting to database...");
			Connection conn = DriverManager
					.getConnection(db, usernamedb, pwddb);
			Statement stmt = conn.createStatement();
			String sql = "";
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
					if (stock1.equals("")) {
						System.out.println("What stock would you like to buy?");
						System.out.println("Inserting row...");

						DaltonStock stock = new DaltonStock(stock1);
						sql = "INSERT INTO Stocks(name, price, timestamp) VALUES ('"
								+ stock.name + "', " + stock.lastprice + ", ";
						stmt.execute(sql);
						System.out
								.println("How many shares would you like to buy?");
						shares2 = input.nextInt();
						money = money - stock.lastprice * shares2;
						System.out.println(buyprice1);
						buyprice1 = stock.lastprice;
						System.out.println(buyprice1);
					} else if (stock2.equals("")) {
						System.out.println("What stock would you like to buy?");
						stock2 = input.nextLine();
						DaltonStock stock222 = new DaltonStock(stock2);
						System.out
								.println("How many shares would you like to buy?");
						shares2 = input.nextInt();
						money = money - stock222.lastprice * shares2;
						buyprice2 = stock222.lastprice;
					}

				} else if (choice.equals("S")) {
					if (!stock1.equals("")) {
						System.out.println("Would you like to sell shares of "
								+ stock1 + "?");
						answer1 = input.nextLine();
						if (answer1.equals("Y")) {
							System.out
									.println("How many shares would you like to sell?");
							sellshares = input.nextInt();
							DaltonStock stock333 = new DaltonStock(stock1);
							double moneymade1 = stock333.lastprice * sellshares
									- buyprice1 * sellshares;
							System.out.println("On this sale you made, "
									+ moneymade1 + " dollars.");
							money = money + stock333.lastprice * sellshares;
							shares1 = shares1 - sellshares;
						} else if (!stock2.equals("")) {
							System.out
									.println("Would you like to sell shares of "
											+ stock2 + "?");
							answer2 = input.nextLine();
							if (answer2.equals("Y")) {
								System.out
										.println("How many shares would you like to sell?");
								DaltonStock stock444 = new DaltonStock(stock2);
								double moneymade2 = stock444.lastprice
										* sellshares - buyprice2 * sellshares;
								System.out.println("On this sale you made, "
										+ moneymade2 + " dollars.");
								money = money + stock444.lastprice * sellshares;
								shares2 = shares2 - sellshares;
							}
						} else {
							System.out.println("Please pick a correct choice");
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
