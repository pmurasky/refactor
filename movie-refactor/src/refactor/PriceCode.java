package refactor;

public class PriceCode {
	public static final int CHILDRENS = 2;
	public static final int REGULAR = 0;
	public static final int NEW_RELEASE = 1;

	private String title;
	private int priceCode;

	double baseAmount;
	int daysLate;
	double lateFee;
	
	public PriceCode(String title, int priceCode) {
		this.title = title;
		this.priceCode = priceCode;
		
		switch (getPriceCode()) {
		case REGULAR:
			baseAmount = 2;
			daysLate = 2;
			lateFee = 1.5;
			break;
		case NEW_RELEASE:
			baseAmount = 0;
			daysLate = 0;
			lateFee = 3;
			break;
		case CHILDRENS:
			baseAmount = 1.5;
			daysLate = 3;
			lateFee = 1.5;
			break;
		}
	}

	
	public int getPriceCode() {
		return priceCode;
	}

	public String getTitle() {
		return title;
	}

	public double calculateRentalFee(int daysRented) {
		double thisAmount = baseAmount;
		if (daysRented > daysLate)
			thisAmount += (daysRented - daysLate) * lateFee;
		return thisAmount;
	}
}