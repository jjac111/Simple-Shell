
import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Files;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 */
public class Command {

    //
    // Possible commands to be excecuted
    //
    public static ArrayList<String> commandList = new ArrayList<>();
    public static ProcessBuilder processBuilder = new ProcessBuilder();
    public static String currentDirectory = "C:\\"; // directorio inicial
    public static String OS = System.getProperty("os.name");

    /**
     * Default constructor
     */
    public Command() {
        try {
            String fileName = "commands.txt";
            FileReader reader = new FileReader(fileName);
            BufferedReader r = new BufferedReader(reader);

            while(r.ready()){
                String line = r.readLine();
                commandList.add(line);
            }

        }

        catch (Exception ex) {
            Logger.getLogger(Command.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    /**
     * @param wholeCommand Executes the input array of String as a command in terminal.
     *
     * Returns the output as a String.
     */
    public String excecute(String wholeCommand) {

        String output = "";

        // save current directory in case cd command passed
        if( wholeCommand.split(" ")[0].equals("cd")){
            String[] splitted = wholeCommand.split(" ");
            currentDirectory = wholeCommand.split(" ")[splitted.length - 1]; // last argument in cd call
        }

        // Contenido del proceso y que termine con apenas una corrida "/c"
        // processBuilder.command("cmd.exe", "/c", wholeCommand);

        // run command
        try {
            Process process;
            if(OS.contains("Windows")){
                ProcessBuilder processBuilder = new ProcessBuilder();
                processBuilder.command("cmd.exe", "/c", wholeCommand);
                process = processBuilder.start();
                process.waitFor();
            }
            else{
                process = Runtime.getRuntime().exec(wholeCommand);
                process.waitFor();
            }

            BufferedReader reader =
                    new BufferedReader(new InputStreamReader(process.getInputStream()));

            // leer linea por linea del resultado de un comando
            // guardar ese contenido en una variable para el respectivo comando
            String line;
            String resultadoComando = "";
            while ((line = reader.readLine()) != null) {
                resultadoComando += (line + '\n');
            }

            output = resultadoComando;
        }
        // Captura input/output exception
        catch (Exception e) {
            e.printStackTrace();
        }

        return output;
    }

    /**
     * @param wholeCommand Executes the input array of String as a command in terminal.
     *
     * Returns the output as a String.
     * Specifically for when the command is ls
     */
    public String executeLs(String wholeCommand){
        String output = "";

        // set the directory of cygwin bin and then if correct, set ls for running
        // processBuilder.command("cd C:\\cygwin64\\bin && " + wholeCommand + " " + currentDirectory);
        // processBuilder.command("cmd.exe", "/c","cd C:\\cygwin64\\bin && " + wholeCommand + " " + currentDirectory);
        // run ls command
        try {
            
                    
            Process process;
            if(OS.contains("Windows")){
                ProcessBuilder processBuilder = new ProcessBuilder();
                processBuilder.command("cmd.exe", "/c","cd C:\\cygwin64\\bin && " + wholeCommand + " " + currentDirectory);
                process = processBuilder.start();
                process.waitFor();
            }
            else{
                process = Runtime.getRuntime().exec(wholeCommand);
                process.waitFor();
            }
            BufferedReader reader =
                    new BufferedReader(new InputStreamReader(process.getInputStream()));

            // leer linea por linea del resultado de un comando
            // guardar ese contenido en una variable para el respectivo comando
            
            String line;
            String resultadoComando = "";
            
            while ((line = reader.readLine()) != null) {
                resultadoComando += (line + '\n');
            }

            output = resultadoComando;
        }
        // Captura input/output exception
        catch (Exception e) {
            e.printStackTrace();
        }

        return  output;
    }

    /**
     * Check that the command is possible to execute
     */
    public boolean validate(String toCheck) throws Exception{

        String command = toCheck.split(" ")[0];

        return commandList.contains(command);
    }

}