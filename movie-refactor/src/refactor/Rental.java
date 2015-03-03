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
		double baseAmount;
		int daysLate;
		double lateFee;
		Calculator(double ba, int dl, double lf) {
			baseAmount = ba;
			daysLate = dl;
			lateFee = lf;
		}
		public double doIt(int daysRented) {
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
			thisAmount = new Calculator(2,2,lateFee).doIt(getDaysRented());
//			thisAmount += 2;
//			if (getDaysRented() > 2)
//				thisAmount += (getDaysRented() - 2) * lateFee;
			break;
		case Movie.NEW_RELEASE:
			thisAmount = new Calculator(0, 0, 3).doIt(getDaysRented());
//			thisAmount += getDaysRented() * 3;
			break;
		case Movie.CHILDRENS:
			thisAmount = new Calculator(1.5, 3, lateFee).doIt(getDaysRented());
//			thisAmount += 1.5;
//			if (getDaysRented() > 3)
//				thisAmount += (getDaysRented() - 3) * lateFee;
			break;
		}
		return thisAmount;
	}
}
