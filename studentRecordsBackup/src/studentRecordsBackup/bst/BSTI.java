package studentRecordsBackup.bst;

public interface BSTI{
    
    /**
    * Insert new node with assigned value to BST
    */
    public void insertNode(NodeI newNode);
    
    /**
     * @return return a string that contains data stored in BST in ascending order
     */ 
    public String printInorder();

    /**
     * Increment all node value by numIn
     */
    public void addValue(int numIn);

    /**
     * @return sum of all values in tree
     */
    public int sum();
}
