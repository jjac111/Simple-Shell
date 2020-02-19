
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

        ProcessBuilder processBuilder = new ProcessBuilder();
        // Contenido del proceso y que termine con apenas una corrida "/c"
        processBuilder.command("cmd.exe", "/c", wholeCommand);

        // run command
        try {
            Process process = processBuilder.start();
            process.waitFor();

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

        ProcessBuilder processBuilder = new ProcessBuilder();
        // set the directory of cygwin bin and then if correct, set ls for running
        processBuilder.command("cmd.exe", "/c", "cd C:\\cygwin64\\bin && " + wholeCommand);

        // run ls command
        try {
            Process process = processBuilder.start();
            process.waitFor();

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