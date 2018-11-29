package gr.skemelio.ping_pong;

import java.net.Socket;

public class MultiServerThread extends Thread{

  private Socket socket;

  public ServerThread(Socket socket){
    this.socket = socket;
  }

  @Override
  public void run(){

  }
}
