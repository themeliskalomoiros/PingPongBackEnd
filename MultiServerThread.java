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
      PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
      BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

      // Server starts with a ping
      out.println(PING);

      while (in.readLine().equals(PONG)) {
        try {
          System.out.println(TAG+": ponged!");
          sleep(getRandomSleepTime());
          out.println(PING);
        }catch (InterruptedException e) {
          break;
        }
      }
    } catch(Exception e) {

    }finally{
      if(socket != null)
        try {
          socket.close();
        } catch(IOException e) {
          System.err.println(TAG+": Error closing socket");
        }
    }
  }

  private Long getRandomSleepTime(){
    Random random = new Random();
    int time = random.nextInt(1000)+1000;
    return (long) time;
  }

}
