package com.skemelio.ping_pong;

import java.net.Socket;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Random;

public class MultiServerThread extends Thread{
  private static final String TAG = "MultiServerThread";
  private static final String PING = "PING";
  private static final String PONG = "PONG";

  private Socket socket;
  private PrintWriter out;
  private BufferedReader in;

  public MultiServerThread(Socket socket){
    this.socket = socket;
  }

  public MultiServerThread(){
    super("MultiServerThread");
  }

  @Override
  public void run(){
    try {
      out = new PrintWriter(socket.getOutputStream(),true);
      in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

      // Server starts with a ping
      out.println(PING);
      System.out.println(TAG+": Pinged client for the first time!");

      String clientResponse;
      while ((clientResponse = in.readLine()).equals(PONG)) {
          System.out.println(TAG+": ponged!");
          pauseForTwoSecondsMax();
          out.println(PING);
          System.out.println(TAG+": pinged back! ;)");
      }
    } catch (IOException e) {
      System.err.println(TAG+": "+e.getMessage());
    } catch (NullPointerException e) {
      System.out.println(TAG+": client disconnected.");
    }finally{
        shutdown();
    }
}

  private Long getRandomSleepTime(){
    Random random = new Random();
    int time = random.nextInt(1000)+1000;
    return (long) time;
  }

  public void shutdown(){
    if (out != null) {
      out.close();
    }
    if(in != null){
      try {
        socket.close();
      } catch(IOException e) {
        System.err.println(TAG+": Error closing socket");
      }
    }
  }

  private void pauseForTwoSecondsMax(){
    try {
      Thread.sleep(getRandomSleepTime());
    } catch(InterruptedException e) {
      System.err.println(TAG+": "+toString()+" was interrupted while sleeping.");
    }
  }

}
