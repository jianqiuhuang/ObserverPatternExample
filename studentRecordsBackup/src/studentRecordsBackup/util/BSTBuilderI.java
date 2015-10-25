package studentRecordsBackup.util;

public interface BSTBuilderI{

    /**
     * Insert a new node to all three BST
     */ 
    public void insert(int numIn);

    /**
     * Increment entire BST by an integer
     */
    public void addValueToNode(int numIn);

    /**
     * Call inorder traversal to print values in all three trees
     */
    public void print();

    /**
     * Print sum of all values in a tree of all three trees
     */
    public void printSum();
}
