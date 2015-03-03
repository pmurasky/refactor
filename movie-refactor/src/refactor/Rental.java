package refactor;

public class Rental {
	private Movie movie;
	private int daysRented;

	public Rental(Movie movie, int daysRented) {
		this.movie = movie;
		this.daysRented = daysRented;
	}

	public int getDaysRented() {
		return daysRented;
	}

	public Movie getMovie() {
		return movie;
	}
	

	class Calculator {
		public double calculateRentalFee(double baseAmount, int daysLate, double lateFee, int daysRented) {
			double thisAmount = baseAmount;
			if (daysRented > daysLate)
				thisAmount += (daysRented - daysLate) * lateFee;
			return thisAmount;
		}
	}
	double amount() {
		double thisAmount = 0;
		final double lateFee = 1.5;
		
		switch (getMovie().getPriceCode()) {
		case Movie.REGULAR:
			thisAmount = new Calculator().calculateRentalFee(2,2,lateFee, getDaysRented());
			break;
		case Movie.NEW_RELEASE:
			thisAmount = new Calculator().calculateRentalFee(0, 0, 3,getDaysRented());
			break;
		case Movie.CHILDRENS:
			thisAmount = new Calculator().calculateRentalFee(1.5, 3, lateFee, getDaysRented());
			break;
		}
		return thisAmount;
	}
}
