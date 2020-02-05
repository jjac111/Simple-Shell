
import java.util.*;

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
        // Leer el archivo de texto y armar commandList 
        
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
        TODO;
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
        TODO;
        String[] commandParts = {};

        // TODO implement here
        // Throws Exception with the possible messages: 
        //      *Command not found: "{commandParts[0]}". 
        //      *Wrong format: Options start with "-" or "--", and are followed by an optional argument.
        
        return commandParts;
    }

}