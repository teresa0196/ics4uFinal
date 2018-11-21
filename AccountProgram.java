import java.io.*; // file stuff
import java.util.*; // string class
import java.awt.*;
import hsa.*;

// The "Program" class.
public class Program
{
    static final int MAXSIZE = 100;
    static int currentSize = 0;


    public static void main (String[] args) throws IOException
    {
	int loc, choice = 0;
	Account[] customerList;
	customerList = createArray ();
	createAccounts (customerList); // read the input file

	while (true)
	{
	    Stdout.println ("\n\n\n");
	    Stdout.println ("\t\t---------");
	    Stdout.println ("\t\tMAIN MENU");
	    Stdout.println ("\t\t---------");
	    Stdout.println ("\t\t1. Customers");
	    Stdout.println ("\t\t2. Show Adminstration Menu");
	    Stdout.println ("\t\t0. Exit Program");
	    Stdout.println ("\t\t---------");
	    Stdout.println ("\n\n");

	    Stdout.print ("Enter your selection -->");
	    choice = Stdin.readInt ();
	    if (choice == 0)
	    {
		// write the data back to file
		// method to write to file
		writeDataToFile (customerList);
		Stdout.println ("Good Bye");

		break;
	    }
	    else if (choice == 1)
	    {
		showCustomersMenu (customerList);

	    else if (choice == 2)
	    {
		showAdministrationMenu ();

	    }
	}

    } // main method


    private static void deleteCustomer (Account[] list, int index)
    {

	if (index > currentSize)
	    return;

	list [index] = null; // delete the item

	for (int i = index ; i < currentSize - 1 ; i++)
	    list [i] = list [i + 1];   // move the item 1 up

	currentSize--;
	return;

    }


    private static void showCustomersMenu (Account[] list)
    {
	int choice, loc;
	while (true)
	{
	    Stdout.println ("\n\n\n");
	    Stdout.println ("\t\t---------");
	    Stdout.println ("\t\tCUSTOMER MENU");
	    Stdout.println ("\t\t---------");
	    Stdout.println ("\t\t1. Show Customers List");
	    Stdout.println ("\t\t2. Add New Customer");
	    Stdout.println ("\t\t3. Delete Customer");
	    Stdout.println ("\t\t0. Go Back to Main Menu");
	    Stdout.println ("\t\t---------");
	    Stdout.println ("\n\n");

	    Stdout.print ("Enter your selection -->");
	    choice = Stdin.readInt ();
	    if (choice == 1)
	    {
		showArray (list);
	    }
	    else if (choice == 2)
	    {
		addNewCustomer (list);
	    }
	    else if (choice == 3)
	    {
		Stdout.println ("Enter location");
		loc = Stdin.readInt ();
		deleteCustomer (list, loc);
	    }
	    else if (choice == 0)
	    {
		break;
	    }
	}

    }


    private static void showAdministrationMenu ()
    {
	int choice;

    }


    private static void writeDataToFile (Account[] list) throws IOException
    {
	String outputFileLoc = "input.txt";
	PrintWriter output;
	output = new PrintWriter (new FileWriter (outputFileLoc));

	output.println (currentSize); // totoal number of objects in array
	for (int i = 0 ; i < currentSize ; i++)
	{
	    output.println (list [i].getName ()); // write name
	    output.println (list [i].getBalance ()); // write balance
	    output.println (); // write blank line
	}
	output.close ();

    }


    private static void createAccounts (Account[] list) throws IOException
    {

	     String inputFileLoc = "input.txt";
	     String str;
	     String name;
	     String bal;
	     double balance;
	     int fileSize;

	BufferedReader infile;
	infile = new BufferedReader (new FileReader (inputFileLoc));

	str = infile.readLine ();
	fileSize = Integer.parseInt (str);

	for (int i = 0 ; i < fileSize ; i++)
	{
	    name = infile.readLine ();
	    bal = infile.readLine ();
	    balance = Double.parseDouble (bal);
	    list [currentSize] = new Account (name, balance);
	    currentSize++;
	    str = infile.readLine (); // read the blank line

	}

	infile.close ();
    }


    private static void addNewCustomer (Account[] list)
    {

	String name;

	double balance;
	Stdout.print ("Enter New Customer Name -->");
	name = Stdin.readLine ();

	Stdout.print ("Enter " + name + " balance -->");
	balance = Stdin.readDouble ();

	list [currentSize] = new Account (name, balance);
	currentSize++;


    }


    private static Account[] createArray ()
    {
	Account[] temp;
	temp = new Account [MAXSIZE];
	return temp;
    }


    private static void showArrayCustomer (Account[] list, int index)
    {

	System.out.print (list [index].getName () + "\t");
	System.out.println (list [index].getBalance ());
    }


    private static void showArray (Account[] list)
    {
	for (int i = 0 ; i < currentSize ; i++)
	{
	    System.out.print (list [i].getName () + "\t");
	    System.out.println (list [i].getBalance ());
	}

    }
}
