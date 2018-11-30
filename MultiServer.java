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

  public MultiServer(){
    super("MultiServer");
  }

  @Override
  public void run(){
    try {
      serverSocket = new ServerSocket(0);
      onServerBoundListener.onServerBound(getHostAddress(),serverSocket.getLocalPort());

      while (true) {
        MultiServerThread thread = new MultiServerThread(serverSocket.accept());
        System.out.println(TAG+": Accepted client");
        thread.start();
        threads.add(thread);
      }
    } catch(IOException e) {
      System.err.println(TAG+": "+e.getMessage());
    }finally{
      if (serverSocket!=null) {
        try {
          serverSocket.close();
        } catch(Exception e) {
          System.err.println(TAG+": Error closing server socket!");
        }
      }
    }
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

  private void shutdown(){
    for (MultiServerThread thread : threads) {
      thread.shutdown();
    }
  }
}
