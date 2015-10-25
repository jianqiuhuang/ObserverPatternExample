package studentRecordsBackup.driver;

import studentRecordsBackup.bst.BSTI;
import studentRecordsBackup.bst.BST;
import studentRecordsBackup.bst.NodeI;
import studentRecordsBackup.bst.Node;
import studentRecordsBackup.observerPattern.SubjectI;
import studentRecordsBackup.observerPattern.ObserverI;
import studentRecordsBackup.util.BSTBuilderI;
import studentRecordsBackup.util.BSTBuilder;
import studentRecordsBackup.fileProcessor.FileProcessor;

public class Driver{
    public static void main(String [] args){
        //Check command line args requirement
        if(args.length != 2){
            System.err.println("Usage: <input-file-name> <increment-value>");
            System.exit(1);
        }
        
        String fileName = args[0];
        int incrementValue = 0;

        //Parsing integers
        try{
            incrementValue = Integer.parseInt(args[1]);
        }catch(Exception e){
            System.err.println("increment value must be an integer" + "\n" + e.getMessage());
            System.exit(1);
        }finally{

        }

        FileProcessor infile = new FileProcessor(fileName, 'r');
        BSTBuilderI test = new BSTBuilder();
        
        //Reading data from file
        String line = null;
        int value = 0;
        while((line = infile.readLineFromFile()) != null){
            try{
                value = Integer.parseInt(line);
            }catch(Exception e){
                System.err.println(e.getMessage());
                infile.closeFile();
                System.exit(1);
            }finally{
                
            }
            test.insert(value);
        }
        //Close file stream
        infile.closeFile();
        //Print data in trees before increment
        test.print();
        //Increment
        test.addValueToNode(incrementValue);
        //Print data in trees after increment
        test.print();
        //Print sum in trees
        test.printSum();
    }
}
