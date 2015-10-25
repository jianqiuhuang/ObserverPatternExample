package studentRecordsBackup.observerPattern;

public interface SubjectI{
    /**
     * Increment the subject by numIn
     */
    public void increment(int numIn);

    /**
     * Insert a new listener to the subejct
     */
    public void addObserver(ObserverI observerIn);

    /**
     * Notify listeners for appropriate updates
     */
    public void notifyAllObservers(int bNumberIn);
}
