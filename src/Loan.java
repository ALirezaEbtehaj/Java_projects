///It stores essential details of loan such as recordId, loanType, interestRate, amountLeft and loanLeft
public abstract class Loan {
    private String recordId;
    private String loanType;
    private double interestRate;
    private int amountLeft;
    private int loanLeft;

    // Default constructor
    public Loan() {
        this.recordId = "";
        this.loanType = "";
        this.interestRate = 0.0;
        this.amountLeft= 0;
        this.loanLeft = 0;
    }

    // Parameterized constructor
    public Loan(String recordId, String loanType, double interestRate, int amountLeft, int loanLeft) {
        this.recordId = recordId;
        this.loanType = loanType;
        this.interestRate = interestRate;
        this.amountLeft= amountLeft;
        this.loanLeft = loanLeft;
    }

    // Record ID read
    public String getRecordId() {
        return recordId;
    }
    //Record ID write
    public void setRecordId(String recordId) {
        this.recordId = recordId;
    }

    //Loan Type read
    public String getLoanType() {
        return loanType;
    }
    //Loan Type write
    public void setLoanType(String loanType) {
        this.loanType = loanType;
    }

    //Interest Rate read
    public double getInterestRate() {

        return interestRate;
    }
    //Interest Rate write
    public void setInterestRate(double interestRate) {

        this.interestRate = interestRate;
    }
    // amount left read
    public int getamountLeft(){
        return amountLeft;
    }
    //amount left write
    public void setAmountLeft(int amountLeft){
        this.amountLeft=amountLeft;
    }
    //Loan left read
    public int getLoanLeft() {
        return loanLeft;
    }
    //Loan left write
    public void setLoanLeft(int loanLeft) {
        this.loanLeft = loanLeft;
    }


}

