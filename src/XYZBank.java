// import hashmap
import java.util.HashMap;
// import map
import java.util.Map;
// import scanner
import java.util.Scanner;


public class XYZBank {

    private Map<String, Customer> customer = new HashMap<>();//Map to store customers with their unique customer IDs as keys.
    private int numRecords = 0;//Number of records currently registered in the bank.
    private int maxrecords;// maximum number of records to register

    public XYZBank(int maxRecords) {
        // max records write
        this.maxrecords = maxRecords;
    }
    //parameterized constructor
    public void registerCustomer(String customerId, double customerIncome) {
        customer.put(customerId, new Customer(customerId, customerIncome));
    }
    public static boolean isValidCustomerId(String customerId) {
        // Check if customerId is 6 characters long
        if (customerId.length() != 6) {
            return false;
        }
        // Check first three characters are uppercase letters
        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(customerId.charAt(i)) || !Character.isUpperCase(customerId.charAt(i))) {
                return false;
            }
        }
        // Check last three characters are digits
        for (int i = 3; i < 6; i++) {
            if (!Character.isDigit(customerId.charAt(i))) {
                return false;
            }
        }
        // If all checks passed, return true
        return true;
    }
    //checks if customer ID is in the right format
    public static String getValidCustomerIdFromInput(Scanner input) {
        String customerId;
        //making a do while loop and the loop repeat itself until it's in the right format
        do {
            //printing the sentence in the bracket
            System.out.println("Enter customer ID (format: AAAXXX): ");
            customerId = input.next();
            // checking fo the validation
            if (!isValidCustomerId(customerId)) {
                // if it's wrong an error pops up
                System.err.println("Invalid customer ID format. Please enter in the format AAAXXX where A is a capital letter and X is a digit.");
            } else {
                // return customerId
                return customerId;
            }
        } while (true);
    }
    // it's get input and return the value
     public static String getCustomerIdFromInput(Scanner input){
        System.out.println("what is customer Id");
        String customerId = input.next();
        return customerId;
    }

    static public double getInterestRateFromInput(Scanner input){
        double interestRate;
        // making a do while loop and checking the values
        do {
            ///define variable Insert_rate as double
            System.out.println("Please put your Insert rate ? ");
            ///get an input from the user
            interestRate = input.nextDouble();
            ///if insert is less than zero flag would change to true and error would pop up
            if (interestRate < 0) {

                System.err.println("value is not valid please put your insert rate above 0");
            }
            /// return intrestrate
            else {
                return interestRate;
            }
            ///while loop repeat itself until value of the flag is true
        } while (true);

    }


    static public int getCustomerIncomeFromInput(Scanner input){
        int income;
        do {
            ///define variable Insert_rate as double
            System.out.println("Please put your Income ? ");
            ///get an input from the user
            income = input.nextInt();
            ///if insert is less than zero flag would change to true and error would pop up
            if (income < 0) {

                System.err.println("value is not valid please put your income above 0");
            }
            ///else flag is false
            else {
                return income;
            }
            ///while loop repeat itself until value of the flag is true
        } while (true);

    }
    static public String getRecordIdFromInput(Scanner input){

        ///define variable RecordID as long
        String recordId;

        ///  do while loop which checks if length of RecordId is 6
        do {
            /// print the sentence in the bracket and goes to next line
            System.out.println("Please put your RecordID (6 digits): ");
            ///input the value of the variable
            recordId = input.next();
            ///if the length of the String is not equal to zero value of flag would be true and error would pop up
            if (recordId.length() != 6 || !recordId.matches("\\d{6}")) { ///correct this
                System.err.println("value is not correct please enter 6 digits");
            }
            /// return recordId
            else {
                return recordId;
            }

        } while (true);
    }
    static public String getLoanTypeFromInput(Scanner input){
        String loanType = "";
        do {
            /// print the sentence in the bracket and goes to next line
            System.out.println("Chose your Loan type(Auto, Builder, Mortgage, Personal, Other) ?");
            /// input the value of the Loan
            loanType = input.next();
            /// it woould call the class getLoan type
            if (!getLoanType(loanType)) {

                System.err.println("value is not valid please select from the giving options(Auto, Builder, Mortgage, Personal, Other) ?");
            } else {
                // else return loantype
                return loanType;
            }
        } while (true);
    }

    static public int getAmountLeftFromInput(Scanner input){
        int amountLeft;
        do {
            /// define variable Amount_left as double
            System.out.println("Please insert the amount you need to pay (it must above 1000 pound) ? ");
            /// define variable Time_left as int
            amountLeft = input.nextInt();
            if (amountLeft <= 1000) {

                System.err.println("value is not correct please enter a number above 1000");

            } else {
                return amountLeft;
            }

        } while (true);


    }
    //get an input loanLeft and return the value
    static public int getLoanLeftFromInput(Scanner input){
        System.out.println("Please type your time left (years) ?");
        int loanLeft = input.nextInt();
        return loanLeft;


    }


    static public double getOverpatement(Scanner input){
        double overpayment;
        // making do while loop and loop would repeat itself until overpayment below 0 and above 2
        do {
            // prints the sentence in the bracket
            System.out.println("for the overpayment please insert a percentage between 0 and 2");
            overpayment = input.nextDouble();
            //it checks tif overpayment between o and 2
            if (overpayment < 0 || overpayment > 2) {
                // prints the sentence in the bracket
                System.err.println("please insert a percentage between 0 and 2");
            } else {
                return overpayment;
            }
        //stays until it is not true
        }while (true);
    }

    //return numrecords
    public int getNumRecords() {
        return numRecords;
    }
    //numRecords increase by 1
    public void incrementNumRecords() {
        numRecords++;
    }

    // maxRecords return
    public int getMaxRecords() {
        return maxrecords;
    }





    public void printCustomerDetails(String customerID) {
        // Retrieve the customer object associated with the provided customerID from the customer map
        Customer addCustomer = customer.get(customerID);
        // If the customer exists
        if (addCustomer != null) {
            // Print the details of the customer
            addCustomer.printing();
            // If the customer does not exist
        } else {
            // Print a message indicating that the customer ID is not found in the system
            System.err.println("Customer ID not found in the system");
        }
    }

    public Customer getCustomer(String customerId) {
        // Retrieve and return the customer object associated with the provided customerID from the customer map
        return customer.get(customerId);
    }

    //printing the details
    public void printAllDetails() {
        //printing max records
        System.out.println("maximum records" + " " + maxrecords);
        // printing numrecords
        System.out.println("Registred records" + " " + numRecords);
        //printing in the sentence
        System.out.println("--------------------------------------------");
        // printing values for the key
        for (Customer customer : customer.values()) {
            customer.printing();
        }
    }

    public static void main(String[] args) {
        // making input as scanner
        Scanner input = new Scanner(System.in);
        // print the sentence in the bracket
        System.out.println("Enter the max records: ");
        int maximum = input.nextInt();
        XYZBank bank = new XYZBank(maximum);

        int choice;
        // make a do while loop that would repeat itself until chose 7
        do {
            //print the sentence in the bracket
            System.out.println("Please choose an option from below");
            //print the sentence in the bracket
            System.out.println("1. Register a new customer");
            //print the sentence in the bracket
            System.out.println("2. Add a record to the customer");
            //print the sentence in the bracket
            System.out.println("3. Print particular information from customer");
            //print the sentence in the bracket
            System.out.println("4. Print all customer details");
            //print the sentence in the bracket
            System.out.println("5. Update the customer income");
            //print the sentence in the bracket
            System.out.println("6. Remove a record from customer");
            //print the sentence in the bracket
            System.out.println("7. Exit");
            //print the sentence in the bracket
            System.out.println("Enter your choice (1-7): ");

            choice = input.nextInt();
            String customerId = "";
            String recordId = "";
            int amountLeft;
            double interestRate;
            int loanLeft;
            double overpayment;
            double income;
            String loanType = "";
            Customer currCustomer;

            //making a switch
            switch (choice) {
                //case 1 would add customerId and Income
                case 1:

                    customerId = getValidCustomerIdFromInput(input);
                    System.out.println("Enter customer income: ");
                    income = input.nextDouble();
                    bank.registerCustomer(customerId, income);
                    break;
                    // add record details to customerId
                case 2:
                    // Obtain the record ID from user input
                    customerId = getCustomerIdFromInput(input);
                    // Retrieve the Customer object associated with the provided customer ID
                    currCustomer = bank.getCustomer(customerId);
                    // Check if the retrieved customer object is not null
                    if (currCustomer != null) {
                        // Check if the maximum number of records has been reached
                        if (bank.getNumRecords() >= bank.getMaxRecords()) {
                            System.err.println("Cannot add anymore records as maximum has been reached");
                        } else {
                            String Loan;
                            // Obtain the record ID from user input
                            recordId = getRecordIdFromInput(input);
                            // Obtain the loan type from user input
                            loanType = getLoanTypeFromInput(input);
                            // Obtain the interest rate from user input
                            interestRate = getInterestRateFromInput(input);
                            // Obtain the remaining amount from user input
                            amountLeft = getAmountLeftFromInput(input);
                            // Obtain the remaining number of payments from user input
                            loanLeft = getLoanLeftFromInput(input);



                            Loan loan = null;
                            // Create a new loan object based on the loan type
                            switch (loanType) {
                                case "Auto":
                                    loan = new AutoLoan(recordId, interestRate, amountLeft, loanLeft);
                                    // Add the new record to the customer and increment the number of records
                                    if (currCustomer.addNewRecord(recordId, loan)) {
                                        bank.incrementNumRecords();
                                    }// Increment number of records
                                    break;

                                case "Builder":
                                    // Obtain the overpayment from user input
                                    overpayment = getOverpatement(input);
                                    loan = new BuilderLoan(recordId, interestRate, amountLeft, loanLeft,overpayment );
                                   if( currCustomer.addNewRecord(recordId, loan)){
                                    bank.incrementNumRecords();
                                   } // Increment number of records
                                    break;
                                case "Mortgage":
                                    // Obtain the overpayment from user input
                                    overpayment = getOverpatement(input);
                                    loan = new MortageLoan(recordId, interestRate, amountLeft, loanLeft,overpayment );
                                    if(currCustomer.addNewRecord(recordId, loan)) {
                                        bank.incrementNumRecords();
                                    }// Increment number of records
                                    break;
                                case "Personal":
                                    // Obtain the overpayment from user input
                                    loan = new PersonalLoan(recordId, interestRate, amountLeft, loanLeft );
                                    if(currCustomer.addNewRecord(recordId, loan)) {
                                        bank.incrementNumRecords();
                                    }// Increment number of records
                                case "Other":
                                    // Obtain the overpayment from user input
                                    loan = new OtherLoan(recordId, interestRate, amountLeft, loanLeft );
                                    if(currCustomer.addNewRecord(recordId, loan)) {
                                        bank.incrementNumRecords();
                                    }// Increment number of records


                                default:
                                    //exit
                                    break;
                            }
                        }

                    } else {
                        // print the sentence in the bracket
                        System.err.println("This CustomerID does not exist");
                    }
                    break;

                case 3:
                    // print the sentence in the bracket
                    System.out.println("1. Print information about a particular user");
                    // print the sentence in the bracket
                    System.out.println("2. Print information about all customers");
                    // print the sentence in the bracket
                    System.out.println("Enter your choice (1 or 2): ");
                    int printChoice = input.nextInt();

                    switch (printChoice) {
                        case 1:
                            // Print information about a particular user
                            System.out.println("Enter customer ID: ");
                            String printCustomerId = input.next();
                            // Print details of the specified customer
                            bank.printCustomerDetails(printCustomerId);
                            break;

                        case 2:
                            // Print information about all customers
                            bank.printAllDetails();
                            break;

                        default:
                            // Inform the user about an invalid choice
                            System.err.println("Invalid choice. Please enter either 1 or 2.");
                            break;
                    }
                    break;
                    // it print all the details
                case 4:
                    bank.printAllDetails();
                    System.out.println();
                    System.out.println();
                    break;
                    //
                case 5:
                    // Obtain the customer ID from user input
                    customerId = getCustomerIdFromInput(input);
                    // Obtain the customer income from user input
                    income = getCustomerIncomeFromInput(input);
                    // Retrieve the Customer object associated with the provided customer ID
                    currCustomer = bank.getCustomer(customerId);
                    // Check if the retrieved customer object is not null
                    if (currCustomer != null) {
                        // Set the income of the retrieved customer to the provided income
                        currCustomer.setCustomerIncome(income);
                    }
                    // If the customer does not exist, print a message indicating so
                    else{
                        System.err.println("This customer id does not exist");
                    }
                    break;
                case 6:
                    // Add logic to remove record from customer
                    customerId = getCustomerIdFromInput(input);
                    recordId = getRecordIdFromInput(input);
                    currCustomer = bank.getCustomer(customerId);
                    // it checks if customerId has been created if yes then removes it
                    if (currCustomer.removeRecord(recordId)){
                        System.out.println("Record removed");
                    }
                    else{
                        System.err.println("This record does not exist.");

                    }
                    break;
                    // exit
                case 7:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.err.println("Invalid choice. Please enter a number between 1 and 7.");
            }
        } while (choice != 7);
        input.close();
    }

    ///this class would check if the value of the loan inserted is one of the values asked or not
    private static boolean getLoanType(String loan) {
        return loan.equalsIgnoreCase("Auto") ||
                loan.equalsIgnoreCase("Builder") ||
                loan.equalsIgnoreCase("Mortgage") ||
                loan.equalsIgnoreCase("Personal") ||
                loan.equalsIgnoreCase("Other");
    }
}