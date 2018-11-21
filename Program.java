import java.io.*;
import java.awt.*;
import javax.swing.JOptionPane;
public class Program
{

  static int currentSize = 0;
  static int numberOfOrder = 0;
  public static void main(String[] args)throws IOException
  {

    FoodMenu[] menuList;
    menuList = createMenuArray();
    createMenu(menuList);

    OrderHistory[] orderList ;
    orderList = createOrderArray();

    while(true)
    {
      showMainMenu(menuList, orderList);
    }


  }

    private static void showMainMenu(FoodMenu[] menuList, OrderHistory[] orderList) throws IOException
    {
      while(true)
    {
      String input;
      int selection = 0;
      String mainMenu = "===================================\n MAIN MENU \n===================================\n 1. CUSTOMER MODE (ORDER FOOD)\n2. ADMINISTRATOR MODE\n 3. Exit Program \n===================================\nEnter your selection : ";
      input = JOptionPane.showInputDialog(mainMenu);
      selection = Integer.parseInt(input);
      if(selection == 1)
      {
        enableCustomerMode(menuList, orderList);
      }
      else if(selection == 2)
      {
        enableAdminMode(menuList, orderList);

      }
      else if(selection == 3)
      {
          writeDataToMenuFile(menuList, orderList);
          System.exit(0);
      }
      //

      }
        }


      private static void enableCustomerMode(FoodMenu[] menuList, OrderHistory[] orderList)throws IOException
      {
        int selection = 0;
        String input = JOptionPane.showInputDialog("\n\n===================================\n\t< CUSTOMER MODE >\n===================================\n1. Order food\n2. View order history\n3. Previous page\n===================================\nEnter your Selection");
        selection = Integer.parseInt(input);
        while(true)
        {
        if(selection == 1)
        {
          showFoodMenu(menuList, orderList);
        }
        else if(selection == 2)
        {
          showOrderHistory(menuList, orderList );
        }
        else if(selection == 3)
        {
          showMainMenu(menuList, orderList);
        }
      }
    }
      private static void enableAdminMode(FoodMenu[] menuList, OrderHistory[] orderList) throws IOException
      {

        String input = JOptionPane.showInputDialog("\n\n===================================\n\t< ADMINISTRATOR MODE\n===================================\n1. Edit menu\n2. View order history(admin)\n3. Previous page\n===================================\nEnter your Selection");
        int selection = Integer.parseInt(input);

        while(true)
        {
        if(selection == 1)
        {
          showEditMenu(menuList, orderList);
        }
        else if(selection == 2)
        {
          showAdminOrderHistory(menuList, orderList);
        }
        else if (selection ==3 )
        {
          showMainMenu(menuList, orderList);
        }
      }
      }

      private static void showOrderFoodScreen(FoodMenu[] menuList, OrderHistory[] orderList)throws IOException
      {
        String input;
        int selection = 0;

        showFoodMenu(menuList, orderList);

      }

      private static void showEditMenu(FoodMenu[] menuList, OrderHistory[] orderList)throws IOException
      {
        String input = JOptionPane.showInputDialog("\n\n===================================\n\t< Edit Menu > \n===================================\n1. Add Menu \n2. Delete Menu \n3. Previous page\n===================================\nEnter your Selection");
        int selection = Integer.parseInt(input);

        if(selection ==1)
        {
          addMenu(menuList, orderList);
        }
        else if(selection ==2)
        {
          deleteMenu(menuList, orderList);
        }
        else if(selection ==3)
        {
          enableAdminMode(menuList, orderList);
        }
      }
      private static void writeDataToMenuFile(FoodMenu[] menuList, OrderHistory[] orderList) throws IOException
      {
        String outputFileLoc = "Menu.txt";
        PrintWriter writer = new PrintWriter(new FileWriter(outputFileLoc));

        writer.println(currentSize);
        for(int i = 0; i< currentSize; i++)
        {
          writer.println(i+1);
          writer.println(menuList[i].getFoodName());
          writer.println(menuList[i].getPrice());
          writer.println(menuList[i].getFoodDescription());
          writer.println(menuList[i].getserving());
          writer.println();
        }
        writer.close();


      }
      private static void createMenu(FoodMenu[] menuList) throws IOException
      {

      }

      private static void addMenu(FoodMenu[] menuList, OrderHistory[] orderList) throws IOException
      {
        String input = JOptionPane.showInputDialog("Enter name : ");
        String foodName = input;
        input = JOptionPane.showInputDialog("Enter description : ");
        String foodDescription = input;
        input = JOptionPane.showInputDialog("Enter price : ");
        double price = Double.parseDouble(input);
        input = JOptionPane.showInputDialog("Enter serving: ");
        int serving = Integer.parseInt(input);

        menuList[currentSize] = new FoodMenu(foodName, price, foodDescription,serving);
        currentSize++;
        writeDataToMenuFile(menuList, orderList);
      }

      private static void showFoodMenu(FoodMenu[] menuList, OrderHistory[] orderList) throws IOException
      {
        String inputFileLoc = "Menu.txt";
        String menuNum = "";
        String name = "";
        String price = "";
        String foodDescription = "";
        String serving = "";

        BufferedReader infile = new BufferedReader(new FileReader(inputFileLoc));
        String input;
        char selection;
        String str = "";
        String line;
        int fileSize;
        while(true)
        {
        fileSize = Integer.parseInt(infile.readLine());
        for(int i = 0; i < fileSize; i++)
        {
         menuNum =infile.readLine() + "\n";
         name = infile.readLine() + "\n";
         price =infile.readLine()+ "\n";
         foodDescription = infile.readLine()+ "\n";
         serving = infile.readLine()+ "\n";
         line = infile.readLine();

         str = menuNum + name + price + foodDescription + serving + line;

         input = JOptionPane.showInputDialog (null, str +  "Enter 'y' for order 'n' for next page 'q' to go back to perevious page.");
         selection = input.charAt(0);
         if(selection == 'y')
         {
           numberOfOrder++;
           orderList[numberOfOrder] = new OrderHistory(name, Double.parseDouble(price));
           writeDataToOrderFile(orderList);
        }

         else if(selection == 'q')
         {
           infile.close();
           enableCustomerMode(menuList, orderList);
         }

        }


      }

      }
      private static void writeDataToOrderFile(OrderHistory[] orderList) throws IOException
      {
        String orderHistoryFileLoc = "CustomerOrderHistory.txt";
        PrintWriter writer = new PrintWriter(new FileWriter(orderHistoryFileLoc));
        for(int i = 0; i <numberOfOrder; i++ )
        {
          writer.println(numberOfOrder);
          writer.println(orderList[i].getFoodName());
          writer.println(orderList[i].getPrice());
        }
        writer.close();
      }
      private static void showOrderHistory(FoodMenu[] menuList, OrderHistory[] orderList)throws IOException
      {
        String orderHistoryFileLoc = "CustomerOrderHistory.txt";
        BufferedReader reader = new BufferedReader(new FileReader(orderHistoryFileLoc));
        String str = "\n";

        for(int i = 0; i<numberOfOrder; i++)
        {
         str = str+reader.readLine();
        }
        reader.close();

        JOptionPane.showMessageDialog(null, "You have ordered\n"+str);
        String input = JOptionPane.showInputDialog("Enter 0 if you want to return to customer menu.");
        int selection = Integer.parseInt(input);
        if (selection == 0)
        {
          enableCustomerMode(menuList, orderList);
        }

      }

     private static void deleteMenu(FoodMenu[] menuList, OrderHistory[] orderList)
      {

      }
      private static void showAdminOrderHistory(FoodMenu[] menuList, OrderHistory[] orderList)
      {

      }

  private static void showPaymentMethodMenu()
  {
    String input = JOptionPane.showInputDialog("1.Cash / 2.Credit / 3. Gift Card\nSelect your payment option \n>>>");
    int selection = Integer.parseInt(input);
    if(selection == 1)
    {

    }
    else if(selection == 2)
    {

    }
    else if(selection == 3)
    {

    }
    }
    private static FoodMenu[] createMenuArray ()
    {
    FoodMenu[] temp;
    temp = new FoodMenu [100];
    return temp;
    }
    private static OrderHistory[] createOrderArray()
    {
      OrderHistory [] temp;
      temp = new OrderHistory[100];
      return temp;
    }
}

// editing, deleting, calculation, sorting in order, adding,
