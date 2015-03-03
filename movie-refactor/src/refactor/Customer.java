package refactor;

import java.util.ArrayList;
import java.util.List;

public class Customer {
	private static final String NEW_LINE = "\n";
	private static final String TAB = "\t";

	private String name;
	private List<Rental> rentals = new ArrayList<Rental>();
	private double totalAmount = 0;
	private int frequentRenterPoints = 0;

	public Customer(String name) {
		this.name = name;
	}

	public void addRental(Rental rental) {
		rentals.add(rental);
	}

	public String getName() {
		return name;
	}

	public String createStatement() {
		StringBuilder statement = new StringBuilder();
		statement.append(createHeader());
		statement.append(createBody());
		statement.append(createFooter());
		return statement.toString();
	}

	private String createBody() {
		StringBuilder lineItems = new StringBuilder();
		for (Rental rental : rentals) {
			lineItems.append(createLineItem(rental));
		}
		return lineItems.toString();
	}

	private String createLineItem(Rental rental) {
		StringBuilder lineItem = new StringBuilder();
		double thisAmount = rental.determineAmountForRental();

		calculateFrequentRenterPoints(rental);

		totalAmount += thisAmount;
		lineItem.append(TAB).append(rental.getMovie().getTitle()).append(TAB)
				.append(thisAmount).append(NEW_LINE);

		return lineItem.toString();
	}

	private void calculateFrequentRenterPoints(Rental rental) {
		frequentRenterPoints++;

		if (rental.getMovie().getPriceCode() == Movie.NEW_RELEASE
				&& rental.getDaysRented() > 1)
			frequentRenterPoints++;
	}

	private String createHeader() {
		return "Rental Record for " + getName() + NEW_LINE;
	}
	
	private String createFooter() {
		StringBuilder footer = new StringBuilder();
		footer.append("You owed ").append(totalAmount).append(NEW_LINE);
		footer.append("You earned ").append(frequentRenterPoints)
				.append(" frequent renter points\n");
		return footer.toString();
	}

	public Double getOwed() {
		return totalAmount;
	}

	public int getPointsEarned() {
		return frequentRenterPoints;
	}
}