package com.skemelio.ping_pong;

import java.io.IOException;

public class PingPongBackendApp implements MultiServer.OnServerBoundListener{

  private MultiServer server;

  public static void main(String[] args) {
    PingPongBackendApp application = new PingPongBackendApp();
    application.printWelcome();
    startMultiServer();

    System.out.println("Type \"exit\" to shutdown the server.");
    while(!System.console().readLine().equalsIgnoreCase("exit")){
      System.out.println("Type \"exit\" to shutdown the server.");
    }
  }

  private void startMultiServer(){
    if (server == null) {
      server = new MultiServer();
      server.setOnServerBoundListener(application);
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

  private void printWelcome(){
    System.out.println("*******************************");
    System.out.println("********* Ping/Pong ***********");
    System.out.println("********* Welcome! ************");
    System.out.println("*******************************\n");
  }
}
