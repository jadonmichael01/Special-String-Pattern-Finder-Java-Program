package util;

public class SingletonException extends Exception{//e.g. "bbbbbbb", "mmmm", "nn"
    private String singletonString;
    private int occurrenceIndex;

    public String getSingletonString() {
        return singletonString;
    }

    @Override
    public String getMessage() {
	return singletonString + " is a singleton string that is found at index " + occurrenceIndex + "!";
    }
    public SingletonException(String singletonString, int index) {
	this.singletonString = singletonString;
	occurrenceIndex = index;
    }
}
