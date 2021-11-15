package Model;

import java.time.LocalDate;
import java.util.Objects;

public class LoanProduct {
	private String productID;
	private String productName;
	private double principalAmount;
	private double tenure;
	private double rateOfInterest;
	private String isActive;
	private String createdBy;
	private LocalDate createdOn;
	private String updatedBy;
	private LocalDate updatedOn;

	public String getProductID() {
		return productID;
	}

	public void setProductID(String productID) {
		this.productID = productID;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getPrincipalAmount() {
		return principalAmount;
	}

	public void setPrincipalAmount(double principalAmount) {
		this.principalAmount = principalAmount;
	}

	public double getTenure() {
		return tenure;
	}

	public void setTenure(double tenure) {
		this.tenure = tenure;
	}

	public double getRateOfInterest() {
		return rateOfInterest;
	}

	public void setRateOfInterest(double rateOfInterest) {
		this.rateOfInterest = rateOfInterest;
	}

	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String string) {
		this.isActive = string;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public LocalDate getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(LocalDate createdOn) {
		this.createdOn = createdOn;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public LocalDate getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(LocalDate updatedOn) {
		this.updatedOn = updatedOn;
	}

	@Override
	public int hashCode() {
		return Objects.hash(createdBy, createdOn, isActive, principalAmount, productID, productName, rateOfInterest,
				tenure, updatedBy, updatedOn);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LoanProduct other = (LoanProduct) obj;
		return Objects.equals(createdBy, other.createdBy) && Objects.equals(createdOn, other.createdOn)
				&& isActive == other.isActive
				&& Double.doubleToLongBits(principalAmount) == Double.doubleToLongBits(other.principalAmount)
				&& Objects.equals(productID, other.productID) && Objects.equals(productName, other.productName)
				&& Double.doubleToLongBits(rateOfInterest) == Double.doubleToLongBits(other.rateOfInterest)
				&& Double.doubleToLongBits(tenure) == Double.doubleToLongBits(other.tenure)
				&& Objects.equals(updatedBy, other.updatedBy) && Objects.equals(updatedOn, other.updatedOn);
	}

	@Override
	public String toString() {
		return "LoanProduct [productID=" + productID + ", productName=" + productName + ", pricipalAmount="
				+ principalAmount + ", tenure=" + tenure + ", rateOfInterest=" + rateOfInterest + ", isActive="
				+ isActive + ", createdBy=" + createdBy + ", createdOn=" + createdOn + ", updatedBy=" + updatedBy
				+ ", updatedOn=" + updatedOn + "]";
	}

}
