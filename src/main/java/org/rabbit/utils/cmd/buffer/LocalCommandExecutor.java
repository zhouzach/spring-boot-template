package org.rabbit.utils.cmd.buffer;

public interface LocalCommandExecutor {
    ExecuteResult executeCommand(String command, long timeout);
}
