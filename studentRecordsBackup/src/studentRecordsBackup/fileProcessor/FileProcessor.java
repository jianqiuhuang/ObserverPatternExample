package studentRecordsBackup.fileProcessor;

import java.io.*;

    /**
    *	Source: http://www.programcreek.com/2011/03/java-read-a-file-line-by-line-code-example/
    **/
public class FileProcessor{
	/**
	 * Construct a BufferedReader from the input file
	 * @param fileName the input file name, which contains lines of strings
     * @param mode 'w' for write, 'r' for read
	 */
	public FileProcessor(String fileName, char modeIn){
		try{
            mode = modeIn;
			File fileStream = new File(fileName);
            if(mode == 'r')
                br = new BufferedReader(new FileReader(fileStream));
            else if(mode == 'w'){
                //If file doesn't exist, then create a new file
                if(!fileStream.exists()){
                    fileStream.createNewFile();
                }
                bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileStream)));
            }else{
                System.err.println("Unrecognizable mode: w - write ... r - read");
                System.exit(1);
            }
		}catch(Exception e){
			System.err.println(e.getMessage());
			e.printStackTrace();
            System.exit(1);    
		}finally{

        }
	}

	/**
	 * @return retrieve a line from the input file specified in the constructor (null if eof)
	 * @exception e print error message and stack trace to stderr and then exit the program
	 */	
	public synchronized String readLineFromFile(){
        if(this.mode != 'r'){
            System.err.println("FileProcessor in write mode, cannot perform read");
            System.exit(1);
        }
		String retVal = null;
		try{
			retVal = br.readLine();
		}catch(Exception e){
			System.err.println(e.getMessage());
			e.printStackTrace();
		}finally{

        }
		return retVal;
	}

    /**
     * Write a single line to file 
     */
    public void writeLineToFile(String line){
        if(this.mode != 'w'){
            System.err.println("FileProcessor in read mode, cannot perform write");
            System.exit(1);
        }
        try{
            bw.write(line);
            bw.newLine();
        }catch(Exception e){
            System.err.println(e.getMessage());
            e.printStackTrace();
        }finally{

        }
    }
	/**
	 * Close file/BufferedReader stream
	 */
	public void closeFile(){
		try{
            if(this.mode == 'r')
    			br.close();
            else if(this.mode == 'w')
                bw.close();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
            
        }
	}	

    public String toString(){
        return "In FileProcessor, file mode is " + mode;
    }
	private BufferedReader br;
    private BufferedWriter bw;
    private char mode;
}
