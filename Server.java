package gr.skemelio.ping_pong;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.IOException;

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

  }

  public void setOnServerUpListener(OnServerUpListener listener){
    onServerUpListener = listener;
  }
}
