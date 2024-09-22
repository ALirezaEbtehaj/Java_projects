//subclasss extends the Loan class
public class OtherLoan extends Loan {
    //default constructor
    public OtherLoan(){
        super();
    }
    //parameterized constructor
    public OtherLoan(String recordId, double interestRate, int amountLeft, int loanLeft){
        super(recordId,"Auto",interestRate,amountLeft,loanLeft);
    }
}