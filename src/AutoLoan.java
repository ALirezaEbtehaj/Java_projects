//subclasss extends the Loan class
public class AutoLoan extends Loan{

    //default constructor
    public AutoLoan(){
        super();
    }
    //parameterized constructor
    public AutoLoan(String recordId, double interestRate, int amountLeft, int loanLeft){
        super(recordId,"Auto",interestRate,amountLeft,loanLeft);
    }


}