# Simple Shell
 Simple shell for excecuting Unix-like commands.

Authors:
	Juan Javier Arosemena
	David Mena
	Alvaro Peña

## To Run:
* Load and Run the netbeans project, the main class is UI.java
* The program uses the file "commands.txt", which is just a list of permissible commands to execute.

## Important consideration:
* The 'ls' command works differently than other commands; it does not pass its output into a stream to be read. I  other words, the command executes, but Java is not able to retrieve its output directly from thhe process that called it.