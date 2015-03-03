package refactor;

public class Rental {
	private PriceCode priceCode;
	private int daysRented;

	public Rental(PriceCode priceCode, int daysRented) {
		this.priceCode = priceCode;
		this.daysRented = daysRented;
	}

	public int getDaysRented() {
		return daysRented;
	}

	public PriceCode getMovie() {
		return priceCode;
	}
}
