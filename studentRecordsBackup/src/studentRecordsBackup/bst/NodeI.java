package studentRecordsBackup.bst;

public interface NodeI{
    /**
     * @return bNumber of this Node
     */
    public int getData();

    /**
     * Set bNumber of this Node
     */
    public void setData(int bNumberIn);

    /**
     * @return left child of this Node
     */
    public NodeI getLeft();

    /**
     * @return right child of this Node
     */
    public NodeI getRight();

    /**
     * set left child of this Node
     */
    public void setLeft(NodeI leftIn);

    /**
     * set right child of this Node
     */
    public void setRight(NodeI rightIn);
    
    /**
     * @return bNumber of this Node
     */
    public String toString(); 
}
