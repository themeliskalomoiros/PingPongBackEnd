package com.skemelio.ping_pong;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.IOException;
import java.net.SocketTimeoutException;
import java.util.List;
import java.util.ArrayList;

// A multiclient server which pings and gets ponged!

public class MultiServer extends Thread{
  private static final String TAG = "MultiServer";
  public static final int INVALID_PORT = -1;

  private List<MultiServerThread> threads = new ArrayList<>();

  public interface OnServerBoundListener{
    void onServerBound(String host, int port);
    void onServerBoundFailure(IOException e);
  }

  private OnServerBoundListener onServerBoundListener;
  private ServerSocket serverSocket;
  private int port = INVALID_PORT;

  public MultiServer(){
    super("MultiServer");
  }

  public MultiServer(int port){
    this();
    this.port = port;
  }

  @Override
  public void run(){
    try {
      initializeServerSocket();
      while (true) {
        MultiServerThread thread = new MultiServerThread(serverSocket.accept());
        System.out.println(TAG+": Accepted client");
        thread.start();
        threads.add(thread);
      }
    } catch(IOException e) {
      System.err.println(TAG+": "+e.getMessage());
    }finally{
      closeServerSocket();
    }
  }

  private void initializeServerSocket() throws IOException{
    if (port == INVALID_PORT){
      serverSocket = new ServerSocket(0);
    }else{
      serverSocket = new ServerSocket(port);
    }
    onServerBoundListener.onServerBound(getHostAddress(),serverSocket.getLocalPort());
  }

  public void setOnServerBoundListener(final OnServerBoundListener listener){
    onServerBoundListener = listener;
  }

  private String getHostAddress(){
    if (serverSocket!=null) {
      return serverSocket.getInetAddress().getHostAddress();
    }
    return null;
  }

  public void shutdown(){
    closeServerSocket();
    for (MultiServerThread thread : threads) {
      thread.shutdown();
    }
  }

  private void closeServerSocket(){
    if (serverSocket!=null) {
      try {
        serverSocket.close();
        serverSocket = null;
      } catch(Exception e) {
        System.err.println(TAG+": Error closing server socket!");
      }
    }
  }
}
