package org.rabbit.service;


import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.concurrent.Executors;
import java.util.function.Consumer;

@Service
public class InvokeShellService {

  private static class StreamGobbler implements Runnable {

    private InputStream inputStream;
    private Consumer<String> consumer;

    public StreamGobbler(InputStream inputStream, Consumer<String> consumer) {
      this.inputStream = inputStream;
      this.consumer = consumer;
    }

    @Override
    public void run() {
      new BufferedReader(new InputStreamReader(inputStream)).lines()
          .forEach(consumer);
    }
  }


  public void execute(String[] shell) throws IOException, InterruptedException {
    Process process;
    process = Runtime.getRuntime().exec(shell);

    StreamGobbler streamGobbler =
        new StreamGobbler(process.getInputStream(), System.out::println);
    Executors.newSingleThreadExecutor().submit(streamGobbler);
//    int exitCode = process.waitFor();
//    System.out.println("exitCode - " + exitCode);
//    assert exitCode == 0;
  }

  public void execute(String shell) throws IOException, InterruptedException {

  }
}
