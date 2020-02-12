
import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Files;
import java.io.File;
import java.nio.file.Path;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 
 */
public class Command {

    //
    // Key: (String) command 
    // Value: (ArrayList) options   [0]: (String) short command -
    //                              [1]: (String) full command --
    //                              [2]: (String) description
    public static Map<String, ArrayList<String[]>> commandList;

    /**
     * Default constructor
     */
    public Command() {
        try {
            String dirName = "commands/";
            ArrayList<String> files = new ArrayList<>();
            
            Files.list(new File(dirName).toPath())
                .forEach(path -> {
                    files.add(path.toString());
                });
            
            
            for (String file : files){
                // Leer el archivo de texto y armar commandList
                
                String command = file.split("/")[1];
                command = command.replace(".txt", "");
                
                FileReader reader = new FileReader(file);
                BufferedReader r = new BufferedReader(reader);
                ArrayList<String[]> options = new ArrayList<>();
                
                //
                // Parse each line
                //
                while(r.ready()){
                    String line = r.readLine();
                    
                    // Remove leading and trailing spaces
                    line = line.trim();
                    
                    String[] commandInfo = line.split("#");
                    
                    String[] parts_ = new String[]{commandInfo[0], commandInfo[1],  commandInfo[2]};
                    
                    options.add(parts_);
                    
                }
                commandList.put(command, options);
            }
        } 
        catch (Exception ex) {
            Logger.getLogger(Command.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     TODO: hard-code the data structure 
     */

    
    /**
     * @param wholeCommand Executes the input array of String as a command in terminal.
     * 
     * Returns the output as a String.
     */
    public String excecute(String[] wholeCommand) {
        
        String output = "";
        
        // TODO implement here
        
        return output;
    }

    /**
     * @param toParse Parses a String to convert it to a String[] defined by:
     * [0]: command name
     * [1]: option 1
     * [2]: argument 1
     * [3]: option 2
     * [4]: argument 2
     * .
     * .
     * . 
     * 
     * Returns a String[].
     */
    public String[] validate(String toParse) throws Exception{
        
        String[] commandParts = {};

        // TODO implement here
        // Throws Exception with the possible messages: 
        //      *Command not found: "{commandParts[0]}". 
        //      *Wrong format: Options start with "-" or "--", and are followed by an optional argument.
        
        return commandParts;
    }

    public static void main(String[] args){
        Command cmd = new Command();
    }
}