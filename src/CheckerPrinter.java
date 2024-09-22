//Interface for objects that perform eligibility checks and printing operations
public interface CheckerPrinter {
    // performs an eligibility check based on the provided amount left
    boolean eligibilityCheck(int amountLeft);
    //Performs the printing operation
    void printing();
}
