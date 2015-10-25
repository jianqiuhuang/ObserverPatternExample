package studentRecordsBackup.util;

import studentRecordsBackup.bst.BSTI;
import studentRecordsBackup.bst.BST;
import studentRecordsBackup.bst.NodeI;
import studentRecordsBackup.bst.Node;
import studentRecordsBackup.observerPattern.SubjectI;
import studentRecordsBackup.observerPattern.ObserverI;

public class BSTBuilder implements BSTBuilderI{
    private BSTI mainBST;
    private BSTI backup1;
    private BSTI backup2;

    public BSTBuilder(){
        mainBST = new BST();
        backup1 = new BST();
        backup2 = new BST();
    }

    /**
     * Insert new element to each tree
     */
    public void insert(int numIn){
        //listeners hold a reference of subject
        NodeI mainNode = new Node(numIn, null);
        NodeI backup1Node = new Node(numIn, (SubjectI)mainNode);
        NodeI backup2Node = new Node(numIn, (SubjectI)mainNode);

        //adding listeners to subject
        SubjectI subject = (SubjectI)mainNode;
        subject.addObserver((ObserverI)backup1Node);
        subject.addObserver((ObserverI)backup2Node);

        //insert new node to tree
        mainBST.insertNode(mainNode);
        backup1.insertNode(backup1Node);
        backup2.insertNode(backup2Node);
    }

    /**
     * update values in main BST
     * Observer pattern should update values in backups automatically
     */
    public void addValueToNode(int numIn){
        mainBST.addValue(numIn);
    }

    /**
     * print value in all tree separately in ascending order
     */
    public void print(){
        System.out.println("Data in main BST (ascending order): " + mainBST.printInorder());
        System.out.println("Data in backup 1 (ascending order): " + backup1.printInorder());
        System.out.println("Data in backup 2 (ascending order): " + backup2.printInorder());
    }

    /**
     * Print sum of all values in a tree of all three trees
     */
    public void printSum(){
        System.out.println("Sum of main BST: " + mainBST.sum());
        System.out.println("Sum of backup 1: " + backup1.sum());
        System.out.println("Sum of backup 2: " + backup2.sum());
    }
}
