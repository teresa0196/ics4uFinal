import java.io.*;
import javax.swing.JOptionPane;

public class Sample
{
  public static void main(String[] args)
  {
    int x = 0;
    String input;
    int selection = 0;
    input = JOptionPane.showInputDialog("===================================\n MAIN MENU \n===================================\n 1. CUSTOMER MODE (ORDER FOOD)\n2. ADMINISTRATOR MODE\n 3. Exit Program \n===================================\nEnter your selection : ");
    selection = Integer.parseInt(input);
    while (x==0)
    {
    if(selection == 1)
    {
      showCustomerMode();

    }
    else if(selection == 2)
    {
      showAdminMode();
    }
    else if(selection == 3)
    {
      System.exit(0);

    }
  }
}
  private static void showCustomerMode()
  {
    String input = JOptionPane.showInputDialog("\n\n===================================\n\t< CUSTOMER MODE >\n===================================\n1. Order food\n2. View order history\n3. Previous page\n===================================\nEnter your Selection");
    int selection = Integer.parseInt(input);
    if(selection == 1)
    {
      showOrderFoodScreen();
    }
    else if(selection ==2)
    {
      showOrderHistory();
    }
    else if(selection == 3)
    {
      break;
    }
  }
  private static void showAdminMode()
  {
    String input = JOptionPane.showInputDialog("\n\n===================================\n\t< ADMINISTRATOR MODE\n===================================\n1. Edit menu\n2. View order history(admin)\n3. Previous page\n===================================\nEnter your Selection");
    int selection = Integer.parseInt(input);

    if(selection == 1)
    {
      showEditMenu();
    }
    else if(selection == 2)
    {
      showAdminOrderHistory();
    }
    else if(selection == 3)
    {
      break;
    }
  }
  private static void showOrderFoodScreen()
  {

  }
  private static void showOrderHistory()
  {

  }

}
