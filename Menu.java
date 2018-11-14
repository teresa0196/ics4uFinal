public class Menu
{
  protected String foodName;
  protected double price;
  protected String foodDescription;
  protected int serving;

  public Menu(String kfoodName, double kprice, String kfoodDescription, int kserve)
    {
      this.foodName = kfoodName;
      this.price = kprice;
      this.foodDescription = kfoodDescription;
      this.serve = kserve;
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
    public int getServe()
    {
      return serve;
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
    public void setServe (int kserve)
    {
      this.serve = kserve;
    }
}
