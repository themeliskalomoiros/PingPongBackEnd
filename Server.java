package gr.skemelio.ping_pong;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.IOException;
import java.net.SocketTimeoutException;

// A multiclient server which pings and gets ponged!

public class Server extends Thread{

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
      while (true) {
        Socket clientSocket = serverSocket.accept();
      }
    } catch (SocketTimeoutException e) {

    } catch(IOException e) {

    }
  }

  public void setOnServerBoundListener(final OnServerBoundListener listener){
    onServerBoundListener = listener;
  }
}
