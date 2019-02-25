package org.rabbit.utils.cmd.buffer;

import lombok.Data;

@Data
//@ToString
public class ExecuteResult {
    private int exitCode;
    private String executeOut;

    public ExecuteResult(int exitCode, String executeOut) {
        this.exitCode = exitCode;
        this.executeOut = executeOut;
    }
}

