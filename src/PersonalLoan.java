//subclasss extends the Loan class
public class PersonalLoan extends Loan {
    //default constructor
    public PersonalLoan(){
        super();
    }
    //parameterized constructor
    public PersonalLoan(String recordId, double interestRate, int amountLeft, int loanLeft){
        super(recordId,"Auto",interestRate,amountLeft,loanLeft);
    }
}