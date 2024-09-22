//subclasss extends the Loan class and add a new attribute called overpayment and give a value zero
public class MortageLoan extends Loan {
    private double overpayment;
    //default constructor
    public MortageLoan(){
        super();
        overpayment = 0.0;
    }
    //parameterized constructor
    public MortageLoan(String recordId, double interestRate,int amountLeft, int loanLeft, double overpayement){
        super(recordId,"Mortage",interestRate,amountLeft,loanLeft);
        this.overpayment = overpayement;
    }
    // overpayemnet Read
    public double getOverpayement(){
        return getOverpayement();
    }
    //overpayement write and the value is between 0 and 2
    public boolean setOverpayment(double overpayment) {
        if(0 > overpayment|| overpayment > 2  ){
            return false;
        }
        else{
            this.overpayment = overpayment;
            return true;
        }
    }
}