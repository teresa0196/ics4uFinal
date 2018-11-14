public class FoodMenu
{
  protected String foodName;
  protected double price;
  protected String foodDescription;
  protected int serving;

  public FoodMenu(String kfoodName, double kprice, String kfoodDescription, int kserving)
    {
      this.foodName = kfoodName;
      this.price = kprice;
      this.foodDescription = kfoodDescription;
      this.serving = kserving;
    }

    public String getFoodNme()
    {
      return foodName;
    }
    public double getPrice()
    {
      return price;
    }
    public String getFoodDescription()
    {
      return foodDescription;
    }
    public int getserving()
    {
      return serving;
    }

    public void setFoodName(String kfoodName)
    {
      this.foodName = kfoodName;
    }
    public void setPrice(double kprice)
    {
      this.price = kprice;
    }
    public void setFoodDescription(String kfoodDescription)
    {
      this.foodDescription = kfoodDescription;
    }
    public void setServing (int kserving)
    {
      this.serving = kserving;
    }
}
