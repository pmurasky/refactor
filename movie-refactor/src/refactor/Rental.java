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

	double determineAmountForRental() {
		double thisAmount = 0;
		final double lateFee = 1.5;
		
		switch (getMovie().getPriceCode()) {
		case Movie.REGULAR:
			thisAmount += 2;
			if (getDaysRented() > 2)
				thisAmount += (getDaysRented() - 2) * lateFee;
			break;
		case Movie.NEW_RELEASE:
			thisAmount += getDaysRented() * 3;
			break;
		case Movie.CHILDRENS:
			thisAmount += lateFee;
			if (getDaysRented() > 3)
				thisAmount += (getDaysRented() - 3) * lateFee;
			break;
		}
		return thisAmount;
	}
}
