
import java.util.*;



/**
 * 
 */
public class UI {

    /**
     * Default constructor
     */
    public UI() {
    }

    /**
     * Takes an input String and separates it into commands. 
     * The separation character is '^'.
     * 
     * Returns a String[] with commands to validate and execute.
     * @param input
     */
    public static String[] parseCommands(String input) {
        //
        // Separate input into commands.
        //
        String[] commands = input.split("^");
        return commands;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("Simple Unix-ish Shell\n");
        Scanner scan = new Scanner(System.in);
        Command cmd = new Command();
        ArrayList<String> history = new ArrayList<>();
        
        //
        // Start shell 
        //
        while(true){
            System.out.println("\n> ");
            
            //
            // and wait for command input.
            //
            String input = scan.next();
            
            //
            // Check for history commands first.
            //
            switch(input){
                
                // Show shell command history.
                case("history"):{
                    
                }
                
                // Execute the first command in history.
                case("!1"):{
                    
                }
                
                // Execute the last command in history.
                case("!#"):{
                    
                }
                
                //
                // If not, attempt to execute shell command(s).
                //
                default:{

                    history.add(input);

                    //
                    // Separate concatenated commands
                    //
                    String[] commands = parseCommands(input);

                    //
                    // Check format and execute every command.
                    //
                    for (String command : commands){

                        //
                        // Throws Exception in case that the format is wrong
                        //
                        try{
                            // Check format
                            String[] toExecute = cmd.validate(command);

                            // Execute and print output
                            String output = cmd.excecute(toExecute);
                            System.out.println(output + "\n\n");
                        }

                        catch(Exception e){
                            System.err.println(e);
                        }
                    }
                }
            }
        }
    }
}