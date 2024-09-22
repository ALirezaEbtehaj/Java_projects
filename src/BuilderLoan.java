//subclasss extends the Loan class and add a new attribute called overpayment and give a value zero
public class BuilderLoan extends Loan {
    private double overpayment;

    //default constructor
    public BuilderLoan() {
        super();
        overpayment = 0;
    }


    //parameterized constructor
    public BuilderLoan(String recordId, double interestRate, int amountLeft, int loanLeft, double overpayment) {
        super(recordId, "Builder", interestRate, amountLeft, loanLeft);
        this.overpayment = overpayment;
    }

    //overpayment read
    public double getOverpayment() {
        return overpayment;
    }

    //overpayment write and checks if value is between 0 and 2
    public boolean setOverpayment(double overpayment) {
        if (0 > overpayment || overpayment > 2) {
            return false;
        } else {
            this.overpayment = overpayment;
            return true;
        }
    }
}