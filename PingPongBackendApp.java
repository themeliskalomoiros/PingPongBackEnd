package com.skemelio.ping_pong;

import java.io.IOException;

public class PingPongBackendApp implements MultiServer.OnServerBoundListener{

  public static void main(String[] args) {
    PingPongBackendApp application = new PingPongBackendApp();
    application.printWelcome();

    MultiServer server = new MultiServer();
    server.setOnServerBoundListener(application);
    server.start();
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
