package gr.skemelio.ping_pong;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.IOException;
import java.net.SocketTimeoutException;

// A multiclient server which pings and gets ponged!

public class MultiServer extends Thread{

  public static final int INVALID_PORT = -1;

  public interface OnServerBoundListener{
    void onServerBound(String host, int port);
    void onServerBoundFailure(IOException e);
  }

  private OnServerBoundListener onServerBoundListener;
  private ServerSocket serverSocket;

  @Override
  public void run(){
    try {
      serverSocket = new ServerSocket(0);
      onServerBoundListener.onServerBound(getHostAddress(),serverSocket.getLocalPort());

      while (true) {
        new MultiServerThread(serverSocket.accept()).start();
      }
    } catch (SocketTimeoutException e) {

    } catch(IOException e) {

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
}
