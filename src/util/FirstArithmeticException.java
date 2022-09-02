package util;

public class FirstArithmeticException extends Exception{
    private String firstArithmeticString;
    private int occurenceIndex;
    @Override
    public String getMessage(){
        return firstArithmeticString + " is an Arithmetic String of Order 1 that is found at index " + occurenceIndex + "!";
    }
    public FirstArithmeticException(String firstArithmeticString, int occurenceIndex){
        this.firstArithmeticString = firstArithmeticString;
        this.occurenceIndex = occurenceIndex;
    }

}
