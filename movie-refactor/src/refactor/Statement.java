package refactor;

public class Statement {

	static final String NEW_LINE = "\n";
	static final String TAB = "\t";
	
	private Customer customer;

	public Statement(Customer customer) {
		super();
		this.customer = customer;
	}

	public String createStatement() {
		StringBuilder statementString = new StringBuilder();
		statementString.append(createHeader());
		statementString.append(createBody());
		statementString.append(createFooter());
		return statementString.toString();
	}

	String createHeader() {
		return "Rental Record for " + customer.getName() + Statement.NEW_LINE;
	}

	String createBody() {
		StringBuilder lineItems = new StringBuilder();
		for (Rental rental : customer.rentals) {
			lineItems.append(createLineItem(rental));
		}
		return lineItems.toString();
	}

	String createFooter() {
		StringBuilder footer = new StringBuilder();
		footer.append("You owed ").append(customer.totalAmount).append(Statement.NEW_LINE);
		footer.append("You earned ").append(customer.frequentRenterPoints)
				.append(" frequent renter points\n");
		return footer.toString();
	}

	private String createLineItem(Rental rental) {
		StringBuilder lineItem = new StringBuilder();
		double thisAmount = rental.getMovie().calculateRentalFee(rental.getDaysRented());
	
		customer.calculateFrequentRenterPoints(rental);
	
		customer.totalAmount += thisAmount;
		lineItem.append(Statement.TAB).append(rental.getMovie().getTitle()).append(Statement.TAB)
				.append(thisAmount).append(Statement.NEW_LINE);
	
		return lineItem.toString();
	}

}
