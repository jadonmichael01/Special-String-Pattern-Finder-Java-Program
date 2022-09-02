package util;

public class TripartiteException extends Exception{
    private String tripartiteString;
    private int occurenceIndex;

    @Override
    public String getMessage(){
        return tripartiteString + " is a Balanced Tripartite String that is found at index " + occurenceIndex + "!";
    }
    public TripartiteException(String tripartiteString, int occurenceIndex){
        this.tripartiteString = tripartiteString;
        this.occurenceIndex = occurenceIndex;
    }
}
