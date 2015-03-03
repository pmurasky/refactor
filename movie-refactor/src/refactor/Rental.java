package refactor;

public class Rental {
	private PriceCode movie;
	private int daysRented;

	public Rental(PriceCode movie, int daysRented) {
		this.movie = movie;
		this.daysRented = daysRented;
	}

	public int getDaysRented() {
		return daysRented;
	}

	public PriceCode getMovie() {
		return movie;
	}
}
