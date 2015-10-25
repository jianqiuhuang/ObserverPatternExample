package studentRecordsBackup.bst;

import java.util.List;
import java.util.ArrayList;
import studentRecordsBackup.observerPattern.ObserverI;
import studentRecordsBackup.observerPattern.SubjectI;

public class Node implements NodeI, ObserverI, SubjectI{
    private int bNumber;
    private NodeI left;
    private NodeI right;

    private ArrayList<ObserverI> observers;
    private SubjectI subject;
    
    public Node(int bNumberIn, SubjectI subjectIn){
        bNumber = bNumberIn;
        left = right = null;
        observers = new ArrayList<ObserverI>();
        subject = subjectIn;
    }

//******************************Observer Pattern Methods****************************
    /**
     * Update listeners's value to subject value
     */
    public void update(int bNumberIn){
        bNumber = bNumberIn;
    }

    /**
     * Subject modifies its value and notifies listeners for update
     */
    public void increment(int numIn){
        bNumber += numIn;
        notifyAllObservers(bNumber);
    }

    /**
     * Subject call this methon to add listeners
     */
    public void addObserver(ObserverI observerIn){
        observers.add(observerIn);
    }

    /**
     * Helper method used to notify listeners there is a change in subject
     */
    public void notifyAllObservers(int bNumberIn){
        for(ObserverI obs : observers)
            obs.update(bNumberIn);
    }

//******************************Regular Node Setter & Getter Methods***************
    /**
     * @return bNumber of this Node
     */
    public int getData(){
        return bNumber;
    }

    /**
     * Set bNumber of this Node
     */
    public void setData(int bNumberIn){
        bNumber = bNumberIn;
    }

    /**
     * @return left child of this Node
     */
    public NodeI getLeft(){
        return left;
    }

    /**
     * Set left child of this Node
     */
    public void setLeft(NodeI leftIn){
        left = leftIn;
    }

    /**
     * @return get right child of this Node
     */
    public NodeI getRight(){
        return right;
    }

    /**
     * Set right child of this Node
     */
    public void setRight(NodeI rightIn){
        right = rightIn;
    }

    /**
     * @return bNumber store in this Node
     */
    public String toString(){
        return Integer.toString(bNumber);
    }
}
