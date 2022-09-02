package util;

public class SecondArithmeticException extends Exception{
    private String secondArithmeticString;
    private int occurenceIndex;

    @Override
    public String getMessage(){
        return secondArithmeticString + " is an Arithmetic String of Order -1 that is found at index " + occurenceIndex + "!";
    }
    public SecondArithmeticException(String secondArithmeticString, int occurenceIndex){
        this.secondArithmeticString = secondArithmeticString;
        this.occurenceIndex = occurenceIndex;
    }
}
