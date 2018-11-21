class Account
{
    protected String name;
    protected double balance;


    public Account (String fname, double fbalance)
    {
	this.name = fname;
	this.balance = fbalance;

    }


    public String getName ()
    {
	return (name);
    }


    public void setName (String fname)
    {
	this.name= fname;
    }


    public double getBalance ()
    {
	return (balance);
    }
}
