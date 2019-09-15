
public class Property extends Plot
{
	
	
	int myPrice;
	int myRentAmount;
	int myMortgageAmount;
	
	public Property(String name, int price, int rent, int mortgage)
	{
		myName = name;
		myPrice = price;
		myRentAmount = rent;
		myMortgageAmount = mortgage;
	}
	
	public String getName()
	{
		return myName;
	}
	
	public int getPrice()
	{
		return myPrice;
	}
	
	public int getRent()
	{
		return myRentAmount;
	}

	public int getMortgage()
	{
		return myMortgageAmount;
	}
}
