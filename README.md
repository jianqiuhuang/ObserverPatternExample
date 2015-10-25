# ObserverPatternExample

Project Description

Backup System for Student Records

Create a class Node to store the B-Number and a description. The data type of the B-Number and description should be int and String respectively. Assume that a student record just has a B-Number. and a description string.
Create a class binary search tree (BST) to store Nodes in accordance with the BST rules applied to the B-Number of each Node.
Create a class BSTBuilder that reads a line from the input file, and calls the insert(...) method of the BST. The input values will not have any duplicates.
Create two copies of the BST tree, backup-1 and backup-2. The three trees, main-BST, backup-1, and backup-2 should be the instances of the same BST class. These backups should be created while the original BST is being created. So, when you insert a node in the main BST, insert in the backup trees also.
The backup-nodes should be listeners for the corresponding node of the main BST.
Each node in backup-1 and backup-2 should be updated using the observer pattern whenever a node in the original BST is changed. It is acceptable to use Java's built-in observer pattern.
Assume that the structure of the tree does not change when an update is made.
From the command line accept the following two args:
An input file, bstInput.txt, with integers that should be used to create the BST. Each line will have one integer. Assume the input integers will not contain any duplicates.
UPDATE_VALUE, an integer.
Add a method to the BST, printInorder(...), that prints to stdout the B-Number in each node.
Your driver code should do the following:
Read command line arguments.
Use BSTBuilder to build the three trees.
Call inorder traversal to print the values from the three trees.
Call methods to print the sum of all the B-Numbers in each of the three trees.
Call a method to increment the nodes in the main BST with UPDATE_VALUE (which will update the backups via the observer pattern).
The BST does not have to handle deletes.
Debug scheme is optional.
