package command;
// invoker que ejecuta comandos
public class ReservationInvoker {
    private Command command;
    public void setCommand(Command command) { this.command = command; }
    public void executeCommand() { command.execute(); }
}
