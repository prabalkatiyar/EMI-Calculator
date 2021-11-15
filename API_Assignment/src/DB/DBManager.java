package DB;

import java.sql.*;
import java.time.LocalDate;
import Model.LoanProduct;

public class DBManager {
	static Connection con = null;

	public DBManager() {
		con = DBConfig.con;
	}

	public void insertProduct(LoanProduct l) throws SQLException {

		String sqlQuery = "Insert into loandb.product(ProductId,ProductName,PrincipalAmount,Tenure,RateofInterest,isActive,CreatedBy,CreatedOn,UpdatedBy,UpdatedOn) values (?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(sqlQuery);
		ps.setString(1, l.getProductID());
		ps.setString(2, l.getProductName());
		ps.setDouble(3, l.getPrincipalAmount());
		ps.setDouble(4, l.getTenure());
		ps.setDouble(5, l.getRateOfInterest());
		ps.setString(6, l.getIsActive());
		ps.setString(7, l.getCreatedBy());
		ps.setDate(8, Date.valueOf(l.getCreatedOn()));
		ps.setString(9, l.getUpdatedBy());
		ps.setDate(10, Date.valueOf(l.getUpdatedOn()));
		ps.executeUpdate();

	}

	public void updateProductProductName(LoanProduct l, String productId, String newProductName) throws SQLException {
		l.setProductName(newProductName);
		String sqlQuery = "Update loandb.product set ProductName=?, UpdatedBy=? , UpdatedOn=?  where ProductId=?";
		PreparedStatement ps = con.prepareStatement(sqlQuery);

		ps.setString(1, l.getProductName());

		l.setUpdatedBy("Arun");
		ps.setString(2, l.getUpdatedBy());

		l.setUpdatedOn(LocalDate.now());
		ps.setDate(3, Date.valueOf(l.getUpdatedOn()));

		ps.setString(4, productId);
		ps.executeUpdate();
	}

	public void updateProductPrincipalAmount(LoanProduct l, String productId, Double newPrincipalAmount)
			throws SQLException {
		l.setPrincipalAmount(newPrincipalAmount);
		String sqlQuery = "Update loandb.product set PrincipalAmount=?, UpdatedBy=? , UpdatedOn=? where ProductId=?";
		PreparedStatement ps = con.prepareStatement(sqlQuery);
		ps.setDouble(1, l.getPrincipalAmount());
		l.setUpdatedBy("Arun");
		ps.setString(2, l.getUpdatedBy());
		l.setUpdatedOn(LocalDate.now());
		ps.setDate(3, Date.valueOf(l.getUpdatedOn()));
		ps.setString(4, productId);
		ps.executeUpdate();
	}

	public void updateProductTenure(LoanProduct l, String productId, Double newTenure) throws SQLException {
		l.setTenure(newTenure);
		String sqlQuery = "Update loandb.product set Tenure=?, UpdatedBy=? , UpdatedOn=? where ProductId=?";
		PreparedStatement ps = con.prepareStatement(sqlQuery);
		ps.setDouble(1, l.getTenure());
		l.setUpdatedBy("Arun");
		ps.setString(2, l.getUpdatedBy());
		l.setUpdatedOn(LocalDate.now());
		ps.setDate(3, Date.valueOf(l.getUpdatedOn()));
		ps.setString(4, productId);
		ps.executeUpdate();
	}

	public void updateProductRateOfInterest(LoanProduct l, String productId, Double newRateOfInterest)
			throws SQLException {
		l.setRateOfInterest(newRateOfInterest);
		String sqlQuery = "Update loandb.product set RateOfInterest=?, UpdatedBy=? , UpdatedOn=? where ProductId=?";
		PreparedStatement ps = con.prepareStatement(sqlQuery);
		ps.setDouble(1, l.getRateOfInterest());
		l.setUpdatedBy("Arun");
		ps.setString(2, l.getUpdatedBy());
		l.setUpdatedOn(LocalDate.now());
		ps.setDate(3, Date.valueOf(l.getUpdatedOn()));
		ps.setString(4, productId);
		ps.executeUpdate();
	}

	public double calculateEMI(LoanProduct l, String productId) throws SQLException {
		String sqlQuery = "Select PrincipalAmount, Tenure, RateOfInterest from loandb.product where ProductId=?";
		PreparedStatement ps = con.prepareStatement(sqlQuery);
		ps.setString(1, productId);
		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			l.setPrincipalAmount(rs.getDouble("PrincipalAmount"));
			l.setTenure(rs.getDouble("Tenure"));
			l.setRateOfInterest(rs.getDouble("RateOfInterest"));

		}

		double p = l.getPrincipalAmount();
		double r = l.getRateOfInterest();
		double n = l.getTenure();
		double emi;
		emi = p * (r / 1200) * (((1 + (r / 1200)) * n) / ((1 + (r / 1200)) * n - 1));
		return emi;
	}

	public void deleteByProductID(String productId) throws SQLException {
		String sqlQuery = "delete from loandb.product where ProductId=?";
		PreparedStatement ps = con.prepareStatement(sqlQuery);
		ps.setString(1, productId.trim());
		ps.executeUpdate();
	}

	public void deleteByProductName(String productName) throws SQLException {
		String sqlQuery = "delete from loandb.product where ProductName=?";
		PreparedStatement ps = con.prepareStatement(sqlQuery);
		ps.setString(1, productName);
		ps.executeUpdate();
	}

	public void viewAllProducts() throws SQLException {
		String sqlQuery = "Select * from loandb.product";
		Statement smt = con.createStatement();
		ResultSet rs = smt.executeQuery(sqlQuery);
		while (rs.next()) {
			System.out.println(rs.getString(1) + " | " + rs.getString(2) + " | " + rs.getDouble(3) + " | "
					+ rs.getDouble(4) + " | " + rs.getDouble(5) + " | " + rs.getString(6) + " | " + rs.getString(7)
					+ " | " + rs.getDate(8) + " | " + rs.getString(9) + " | " + rs.getDate(10));
		}

	}

}
