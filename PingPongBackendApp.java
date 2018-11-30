package com.skemelio.ping_pong;

import java.io.IOException;

public class PingPongBackendApp implements MultiServer.OnServerBoundListener{
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
    System.out.printf("A server bound succesfully!\nHost:\t%s\nPort:%d\t",host,port);
  }

  @Override
  public void onServerBoundFailure(IOException e){
    System.out.println(e.getMessage());
  }

  private void waitForUserToExit(){
    System.out.println("Reminder: You need to type \"exit\" if you wish to shutdown the server and close the application.");
    while(!System.console().readLine().equalsIgnoreCase("exit")){
      System.out.println("Type \"exit\".");
    }
    System.exit(1);
  }

  private void printWelcome(){
    System.out.println("*******************************");
    System.out.println("********* Ping/Pong ***********");
    System.out.println("********* Welcome! ************");
    System.out.println("*******************************\n");
  }
}
