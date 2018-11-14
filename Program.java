import java.io.*;
import java.util.Scanner;
import javax.swing.JOptionPane;
public class Program
{
  public static void main(String[]args)throws IOException
  {
    Scanner scanner = new Scanner(System.in);
    FoodMenu[] foodList;
    int selection;
    String input;

    String mainMenu = "===================================\n MAIN MENU \n===================================\n 1. CUSTOMER MODE (ORDER FOOD)\n2. ADMINISTRATOR MODE\n ===================================\n";

    //while (true)

    //  {

    input = JOptionPane.showInputDialog(mainMenu+"Enter your Selection : ");
    selection = Integer.parseInt(input);

    if(selection == 1)
    {
        input = JOptionPane.showInputDialog("\n\n===================================\n\t< CUSTOMER MODE\n===================================\n1. Order food\n2. View order history\n3. Previous page\n===================================\nEnter your Selection");


        selection = Integer.parseInt(input);

      if(selection == 1)
      {
        System.out.println("1. Appetizers");
        System.out.println("2. Meals");
        System.out.println("3. Drinks");
        System.out.println("4. Desserts ");
        System.out.println("5. Others");
        System.out.print("Choose a category\n>>> ");
        selection = scanner.nextInt();
        if(selection == 1);
        {
          System.out.println("< 1. Appetizers >");
          System.out.println("Menu Number / Price / Description / Serving");
          System.out.println("1-1 Shrimp Fries / $4.99 / fried shrimp / 1");
          System.out.println("1-2 Vegetable Congee / $4.99 / congee with vegetables mixed");
          System.out.println("1-3 Rolled Omelet / $5.99 / Korean-style rolled omelets");
          System.out.println("1-4 )");
          System.out.print(">>> Enter your Selection\n>>> ");
        }
        System.out.print(">>> Enter your Selection\n>>> ");

        selection = scanner.nextInt();
      }
      else if (selection == 2);
      {
        System.out.println("<2. Meals >");
        System.out.println("Menu Number / Price / Description / Serving");
        System.out.println("2-1 Samgyeopsal /9.99/  Grilled pork belly / n 인");
        System.out.println("2-2 Beef Brisket/ ");
        System.out.println("");


        System.out.println("B-2");
      }




    }



    //}
  }
  public void showPaymentMethodMenu()
  {
    System.out.println("1.Cash / 2.Credit / 3. Gift Card");
    System.out.println("Select your payment option \n>>> ");
    System.out.println("");
  }

}
