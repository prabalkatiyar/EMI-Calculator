package UI;

import java.util.*;

public class MainClass {
	public static void main(String[] args) {
		UIBackend ui = new UIBackend();
		Scanner in = new Scanner(System.in);
		int ch;
		while (true) {

			System.out.println("1) Insert Loan Product");
			System.out.println("2) Update Product Name");
			System.out.println("3) Update Principal Amount");
			System.out.println("4) Update Tenure ");
			System.out.println("5) Update Rate of Interest");
			System.out.println("6) Calculate EMI");
			System.out.println("7) Delete by Product ID");
			System.out.println("8) Delete by Product Name");
			System.out.println("9) View All Products");
			System.out.println("10) Exit");

			ch = Integer.parseInt(in.nextLine());
			switch (ch) {
			case 1:
				ui.insertProduct();
				break;
			case 2:
				ui.updateProductProductName();
				break;
			case 3:
				ui.updateProductPrincipalAmount();
				break;
			case 4:
				ui.updateProductTenure();
				break;
			case 5:
				ui.updateProductRateOfInterest();
				break;
			case 6:
				ui.calculateEMI();
				break;
			case 7:
				ui.deleteByProductId();
				break;
			case 8:
				ui.deleteByProductName();
				break;
			case 9:
				ui.viewAllProducts();
				break;
			case 10:
				System.exit(1);
				break;
			default:
				System.out.println("Invalid Input");

			}
		}

	}
}
