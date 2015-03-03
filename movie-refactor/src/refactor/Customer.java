package refactor;

import java.util.ArrayList;
import java.util.List;

public class Customer {
	private String name;
	List<Rental> rentals = new ArrayList<Rental>();
	double totalAmount = 0;
	int frequentRenterPoints = 0;

	public Customer(String name) {
		this.name = name;
	}

	public void addRental(Rental rental) {
		rentals.add(rental);
	}

	public String getName() {
		return name;
	}
	
	void calculateFrequentRenterPoints(Rental rental) {
		frequentRenterPoints++;

		if (rental.getMovie().getPriceCode() == PriceCode.NEW_RELEASE
				&& rental.getDaysRented() > 1)
			frequentRenterPoints++;
	}

	public Double getOwed() {
		return totalAmount;
	}

	public int getPointsEarned() {
		return frequentRenterPoints;
	}
}