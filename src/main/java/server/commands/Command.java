package server.commands;

public interface Command {
    /**
     * Base method for show command name
     *
     * @return command name
     */
    String getName();

    /**
     * Base method for show command description.
     *
     * @return command description
     */
    String getDescr();

    /**
     * Base method for show command arguments
     *
     * @return command arguments pattern
     */
    default String getArgs()
    {
        return "";
    }

    /**
     * Base method for command executing.
     */
    void execute();
}
