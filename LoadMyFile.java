import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author eporchetta
 */
public class LoadMyFile {
    private ArrayList<String> lines = new ArrayList<String>();
    private String[] storedLines;
    private String line;
    private File file;
    
    //Constructor
    public LoadMyFile(String fileLocation ) throws FileNotFoundException, IOException{
       
        file = new File(fileLocation);
        //Open file to be read.
        BufferedReader in = new BufferedReader( new FileReader(file));
        line = in.readLine();
        //Skip the first line which has labels of columns.
        /*
        if (line != null) 
            line = in.readLine();
        */
        while(line != null){
            lines.add(line);
            line = in.readLine();
        }
        if (lines.size() > 0){
            //Create the size of the array of String since we now know and
            //add each line sequential into the array StoredLines
            storedLines = new String[lines.size()];
            storedLines = lines.toArray(storedLines);
        }
    }
    //Get the lines returning an arrayList
    public ArrayList<String>  getLinesList(){
        //Pass only a copy of the file so that the original data can not be modified
        ArrayList<String> tempLines = new ArrayList<String>(lines);
        return tempLines ;
    }

    //Get the returning an array
    public String[]  getLinesArray(){
        //Pass only a copy of the file so that the original data can not be modified
        
        return storedLines.clone() ;
    }    
    
    //Returns text in file as a string
    public String getString () {
        return line;
    }
    
    //Returns File object
    public File getFile () {
        return file;
    }
}
