package com.skemelio.ping_pong;

import java.io.IOException;

public class PingPongBackendApp implements MultiServer.OnServerBoundListener{
  private static final String TAG = "PingPongBackendApp";
  private static final int WELCOME_MESSAGE_SIZE = 31;

  private MultiServer server;

  public static void main(String[] args) {
    PingPongBackendApp application = new PingPongBackendApp();
    application.printWelcome();
    application.startMultiServer();
    application.waitForUserToExit();
  }

  private void startMultiServer(){
    if (server == null) {
      server = new MultiServer();
      server.setOnServerBoundListener(this);
      server.start();
    }
  }

  @Override
  public void onServerBound(String host, int port){
    System.out.printf(TAG+": A server bound succesfully at\n\t\t\tHost:\t%s\n\t\t\tPort:%d\t",host,port);
  }

  @Override
  public void onServerBoundFailure(IOException e){
    System.out.println(e.getMessage());
  }

  private void waitForUserToExit(){
    System.out.println(TAG+": type \"exit\" if you wish to shutdown the server and close the application.");
    while(!System.console().readLine().equalsIgnoreCase("exit")){
      System.out.println(TAG+": type \"exit\".");
    }
    System.exit(1);
  }

  private void printWelcome(){
    printStarsWithDelay();
    System.out.println("********* Ping/Pong ***********");
    System.out.println("********* Welcome! ************");
    printStarsWithDelay();
    System.out.println();
  }

  private void printStarsWithDelay(){
    for (int i=0; i<WELCOME_MESSAGE_SIZE; i++) {
      System.out.print("*");
      try {
        Thread.sleep(30);
      } catch(InterruptedException e) {
        System.err.println(TAG+": error while sleep in printStarsWithDelay()");
      }
    }
    System.out.println();
  }
}
