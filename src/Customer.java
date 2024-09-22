// import hashmap
import java.util.HashMap;
// import map
import java.util.Map;

public class Customer implements CheckerPrinter {
    private String customerID;// unique identifier
    private double customerIncome;// income of the customer
    private boolean eligibilityStatus;// eligibility status
    private int totalLoanAmount;//total amount taken by the customer
    private Map<String, Loan> creditRecords = new HashMap<>(); // Map to store credit records associated with the customer


    // Default constructor
    public Customer(){
        this.customerID="AAAZZZ";
        this.customerIncome= 0.0;
        this.totalLoanAmount = 0;

    }
    // Parameterized constructor
    public Customer(String customerID, double customerIncome) {
        this.customerID = customerID;
        this.customerIncome = customerIncome;
        this.totalLoanAmount = 0;

    }
    //customerID read
    public String getCustomerID() {
        return customerID;
    }

    //customerIncome write
    public double getCustomerIncome() {
        return customerIncome;
    }

    // it checks if  the total amount is less or equal 4 times the customer income
    public boolean isEligibilityStatus() {
        return (this.totalLoanAmount) <= (4 * this.getCustomerIncome());
    }

    // customerID write
    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    //customerIncome write
    public void setCustomerIncome(double customerIncome) {
        this.customerIncome = customerIncome;
    }

    // eligibilitystatus write
    public void setEligibilityStatus(boolean eligibilityStatus) {
        this.eligibilityStatus = eligibilityStatus;
    }

    // Overriding methods
    @Override
    public boolean eligibilityCheck(int amountLeft) {
        // Calculate the maximum allowable remaining loan amount based on income (four times the income)
        return (amountLeft) <= (4 * this.getCustomerIncome());
    }

    // total amount read
    public int getTotalLoanAmount() {
        return this.totalLoanAmount;
    }

    // overriding methods
    @Override

    public void printing() {
        // printing the sentence in the brackets + CustomerID
        System.out.println("CustomerID is: " + getCustomerID());
        // printing the sentence in the brackets + customerincome
        System.out.println("Customer Income is: " + getCustomerIncome());
        //// printing the sentence in the brackets + TotalAmount
        System.out.println("Customer Total Loan Amount is: " + getTotalLoanAmount());
        // printing the sentence in the brackets + isEligibilityStatus + yes or no
        System.out.println("Eligible to arrange new loans - " + (isEligibilityStatus() ? "Yes" : "No"));
        // printing in a specific format
        System.out.format("%-13s%-13s%-13s%-13s%-13s\n", "RecordID ", "LoanType", "IntRate ", "AmountLeft", "TimeLeft");
        // making a loop which goes to each key and print the values in a specific form
        for (String recordId: creditRecords.keySet()) {
            Loan loanDetails = creditRecords.get(recordId);
            System.out.printf("%-13s%-13s%-13.2f%-13d%-13d\n", recordId, loanDetails.getLoanType(), loanDetails.getInterestRate(), loanDetails.getamountLeft(), loanDetails.getLoanLeft());
        }
        //printing the sentence in the bracket
        System.out.println("=========================================");
    }

    // ma
    public boolean addNewRecord(String recordId,Loan loan) {
        //Check if the customer is eligible based on total loan amount and current loan amount
        boolean totalEligibility = isEligibilityStatus();
        boolean currentEligibility = eligibilityCheck(loan.getamountLeft());
        // If the customer is eligible for both total and current loan amounts
        if (totalEligibility && currentEligibility ) {
            // Add the new record to the credit records
            creditRecords.put(recordId,loan);
            // Update the total loan amount for the customer
            this.totalLoanAmount += loan.getamountLeft();
            return true;
        }
        // If the customer is eligible based on current loan amount but not eligible based on total loan amount
        else if(currentEligibility) {
            System.err.println("Customer is not eligible for this loan: current total loan  is more than 4 times customer's income");
            return false;
        }
        // If the customer is not eligible based on current loan amount
        else{
            System.err.println("Customer is not eligible for this loan: loan amount  is more than 4 times customer's income");
            return false;
        }
    }
    public boolean removeRecord(String recordId){
        // Retrieve the loan associated with the recordId
        Loan loan =creditRecords.get(recordId);
        if (loan != null) {
            // Subtract the amount of the removed loan from the total loan amount
            totalLoanAmount -= loan.getamountLeft();
            // Remove the record from the credit records
            creditRecords.remove(recordId);
            return true;
        }
        // goes back to the loop
        else {
        return false;
        }
    }
}
