package UI;

import java.sql.SQLException;
import java.text.DateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

import DB.DBManager;
import Model.LoanProduct;

public class UIBackend {
	LoanProduct l;
	DBManager dbManager = new DBManager();
	Scanner in = new Scanner(System.in);

	public void insertProduct() {

		l = new LoanProduct();

		System.out.println("Enter Product ID : ");
		l.setProductID(in.nextLine());

		System.out.println("Enter Product Name : ");
		l.setProductName(in.nextLine());

		System.out.println("Enter Principal Amount : ");
		l.setPrincipalAmount(Double.parseDouble(in.nextLine()));

		System.out.println("Enter Tenure : ");
		l.setTenure(Double.parseDouble(in.nextLine()));

		System.out.println("Enter Rate of Interest : ");
		l.setRateOfInterest(Double.parseDouble(in.nextLine()));

		System.out.println("Enter Active Status : ");
		l.setIsActive(in.nextLine());

		System.out.println("Created by: ");
		l.setCreatedBy(in.nextLine());

		System.out.println("Created on:");
		String s = in.nextLine();
		DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate createDate = LocalDate.parse(s, format);
		l.setCreatedOn(createDate);

		System.out.println("Updated by: ");
		l.setUpdatedBy(in.nextLine());

		System.out.println("Updated on: ");
		String u = in.nextLine();
		LocalDate updatedDate = LocalDate.parse(u, format);
		l.setUpdatedOn(updatedDate);

		try {
			dbManager.insertProduct(l);
		} catch (SQLException e) {
			System.out.println(e);
		}
	}

	public void updateProductProductName() {
		l = new LoanProduct();
		System.out.println("Enter Product ID:");
		String id = in.nextLine();
		System.out.println("Enter New Name of Product:");
		String newName = in.nextLine();
		try {
			dbManager.updateProductProductName(l, id, newName);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void updateProductPrincipalAmount() {
		l = new LoanProduct();
		System.out.println("Enter Product ID:");
		String id = in.nextLine();
		System.out.println("Enter New Principal Amount:");
		double newPrincipalAmount = Double.parseDouble(in.nextLine());
		try {
			dbManager.updateProductPrincipalAmount(l, id, newPrincipalAmount);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void updateProductTenure() {
		l = new LoanProduct();
		System.out.println("Enter Product ID:");
		String id = in.nextLine();
		System.out.println("Enter New Tenure:");
		double newTenure = Double.parseDouble(in.nextLine());
		try {
			dbManager.updateProductTenure(l, id, newTenure);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void updateProductRateOfInterest() {
		l = new LoanProduct();
		System.out.println("Enter Product ID:");
		String id = in.nextLine();
		System.out.println("Enter New Rate of Interest:");
		double newRateOfInterest = Double.parseDouble(in.nextLine());
		try {
			dbManager.updateProductRateOfInterest(l, id, newRateOfInterest);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void calculateEMI() {
		l = new LoanProduct();
		System.out.println("Enter Product ID:");
		String id = in.nextLine();
		try {
			double emi = dbManager.calculateEMI(l, id);
			System.out.println("Emi is : " + emi);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void deleteByProductId() {
		try {
			System.out.println("Enter Product Id");
			String productId = in.nextLine();
			dbManager.deleteByProductID(productId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void deleteByProductName() {
		try {
			System.out.println("Enter Product Name");
			String productName = in.nextLine();
			dbManager.deleteByProductID(productName);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void viewAllProducts() {
		try {
			dbManager.viewAllProducts();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
