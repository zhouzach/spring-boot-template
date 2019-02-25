package org.rabbit.utils.cmd.buffer;

public class Main {

    public static void main(String[] args) {


        LocalCommandExecutor cmd = new LocalCommandExecutorImpl();
        ExecuteResult result = cmd.executeCommand("bash ./echo.sh ,zach", 1000);
        System.out.println("code: " + result.getExitCode());
        System.out.println("res: " + result.getExecuteOut());
        System.out.println("finished");
    }
}
