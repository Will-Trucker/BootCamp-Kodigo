package command;

public class ReservationInvoker {
    private Command command;
    public void setCommand(Command command) { this.command = command; }
    public void executeCommand() { command.execute(); }
}
