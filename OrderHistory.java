public class OrderHistory
{
  protected String foodName;
  protected double price;

  public OrderHistory(String fn, double p)
  {
    foodName = fn;
    price = p;
  }

  public String getFoodName()
  {
    return foodName;
  }
  public double getPrice()
  {
    return price;
  }
  public void setFoodName(String fn)
  {
    this.foodName = fn;
  }
  public void setPrice(double p)
  {
    this.price = p;
  }
}
