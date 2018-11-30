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

  public MultiServerThread(Socket socket){
    this.socket = socket;
  }

  public MultiServerThread(){
    super("MultiServerThread");
  }

  @Override
  public void run(){
    try {
      PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
      BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

      // Server starts with a ping
      out.println(PING);
      System.out.println(TAG+": Just pinged client!");

      while (true) {
          String clientResponse = in.readLine();
          if (clientResponse == null || !clientResponse.equals(PONG)){
            System.out.println(TAG+" client does not want to play anymore... :(");
            break;
          }
          System.out.println(TAG+": ponged!");
          try {
            Thread.sleep(getRandomSleepTime());
          } catch(InterruptedException e) {
            System.err.println(TAG+": "+toString()+" was interrupted while sleeping.");
          }
          out.println(PING);
          System.out.println(TAG+": pinged back! ;)");
      }
    } catch (IOException e) {
      System.err.println(TAG+": "+e.getMessage());
    } finally{
        if(socket != null){
          try {
            socket.close();
          } catch(IOException e) {
            System.err.println(TAG+": Error closing socket");
          }
        }
    }
}

  private Long getRandomSleepTime(){
    Random random = new Random();
    int time = random.nextInt(1000)+1000;
    return (long) time;
  }

}
