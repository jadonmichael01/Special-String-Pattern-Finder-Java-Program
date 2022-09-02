package util;

public class PalindromeException extends Exception{
    private String palindromeString;
    private int occurenceIndex;

    public String getPattern() {
        return palindromeString;
    }

    @Override
    public String getMessage(){
        return palindromeString + " is a Palindrome that is found at index " + occurenceIndex + "!";
    }
    public PalindromeException(String palindromeString, int occurenceIndex){
        this.palindromeString = palindromeString;
        this.occurenceIndex = occurenceIndex;
    }
}
