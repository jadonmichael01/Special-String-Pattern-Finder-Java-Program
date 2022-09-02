package util;

public class BipartiteException extends Exception{
    private String bipartiteString;
    private int occurrenceIndex;

    @Override
    public String getMessage() {
        return bipartiteString + " is a balanced bipartite string that is found at index " + occurrenceIndex + "!";
    }

    public BipartiteException(String singletonString, int index) {
        this.bipartiteString = singletonString;
        occurrenceIndex = index;
    }
}
