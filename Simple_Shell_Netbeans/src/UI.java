
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
        String[] commands = input.split("\\^");
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
            System.out.print("\n> ");


            //
            // and wait for command input.
            //
            String input = scan.nextLine();

            //
            // Check for history commands first.
            //
            switch(input){

                // Show shell command history.
                case("history"):{
                    System.out.println("History");
                    if (!history.isEmpty()){
                        for (String command : history)
                            System.out.println(command);
                    }
                    input = "";
                    break;
                }

                // Execute the first command in history.
                case("!1"):{
                    System.out.println("First Command");
                    String firstCommand = history.get(0); 
                    input = firstCommand;
                    break;
                }

                // Execute the last command in history.
                case("!#"):{
                    int history_length = history.size() - 1;
                    System.out.println("Last command");
                    String lastCommand = history.get(history_length);
                    input = lastCommand;
                    break;
                            
                }

                //
                // If not, attempt to execute shell command(s).
                //
                default:{
                    
                    history.add(input);
                    if (history.size() >= 11) history.remove(0);
                }
                
                if (!input.isEmpty()){
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
                            String output;
                            if(!cmd.validate(command)){
                                output = ">>> The input command "+command+" is not available.";
                            }
                            else if( command.split(" ")[0].equals("ls")){
                                output = cmd.executeLs(command);
                            }
                            else{
                                // Execute and print output
                                output = cmd.excecute(command);
                            }
                            System.out.println(output);
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