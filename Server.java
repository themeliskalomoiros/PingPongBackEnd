package gr.skemelio.ping_pong;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.IOException;
import java.net.SocketTimeoutException;

// A multiclient server which pings and gets ponged!

public class Server extends Thread{

  public interface OnServerUpListener{
    void onServerUp(String host, int port);
    void onServerUpFailure(IOException e);
  }

  private OnServerUpListener onServerUpListener;
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

  public void setOnServerUpListener(OnServerUpListener listener){
    onServerUpListener = listener;
  }
}
