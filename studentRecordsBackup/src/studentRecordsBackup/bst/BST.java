package studentRecordsBackup.bst;

import java.util.Vector;
import studentRecordsBackup.observerPattern.SubjectI;
public class BST implements BSTI{
    private NodeI root;
    
    public BST(){
        root = null;
    }

    /**
     * Helper method used to determine the correct position to place new node
     */
    private void insertHelper(NodeI head, NodeI newNode){
        int num = newNode.getData();
        //if new node is greater then curr node
        if(head.getData() <= num){
            //if current node's right child is null
            //append the new node 
            if(head.getRight() == null)
                head.setRight(newNode);
            //recursively call the method on current node
            //right child
            else
                insertHelper(head.getRight(), newNode);
        }else{
            if(head.getLeft() == null)
                head.setLeft(newNode);
            else
                insertHelper(head.getLeft(), newNode);
        }
    }

    /**
     * Insert new node with assigned value to BST
     */
    public void insertNode(NodeI newNode){
        //first node
        if(root == null)
            root = newNode;
        else
            insertHelper(root, newNode);    
    }

    /**
     * Helper method for addValue
     * This method should only be invoke by subject
     */
    public void addValueHelper(NodeI head, int numIn){
        if(head == null)
            return;
        else{
            //Call increment method from SubjectI
            SubjectI subject = (SubjectI)head;
            //This method will update values in backups too
            subject.increment(numIn);
        }
        addValueHelper(head.getLeft(), numIn);
        addValueHelper(head.getRight(), numIn);
    }
    
    /**
     * Increment all node value by numIn
     */
    public void addValue(int numIn){
        NodeI head = root;
        addValueHelper(head, numIn);
    }

    /**
     * BST in-order Traversal 
     * Store data in resule (String Vector)
     */ 
    private void inOrderTraversal(NodeI head, Vector<Integer> result){
        if(head == null)
            return;
        inOrderTraversal(head.getLeft(), result);
        result.addElement(head.getData());
        inOrderTraversal(head.getRight(), result);
    }

    /**
     * @return ordered (ascending) data store in BST
     * Append String data in Vector result to String retval
     */
    public String printInorder(){
        Vector<Integer> result = new Vector<Integer>();
        String retVal = "";
        inOrderTraversal(root, result);
        for(int i = 0; i < result.size(); ++i){
            retVal = retVal + Integer.toString(result.get(i)) + ", ";
        }
        return retVal;   
    }

    /**
     * @return sum of all values in tree
     */
    public int sum(){
        Vector<Integer> result = new Vector<Integer>();
        int sum = 0;
        inOrderTraversal(root, result);
        for(int i = 0; i < result.size(); ++i){
            sum += result.get(i);
        }
        return sum;
    }
}
