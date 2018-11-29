package gr.skemelio.ping_pong;

public class PingPongBackendApp{
  public static void main(String[] args) {
    printWelcome();
    MultiServer server = new MultiServer();
  }

  private static void printWelcome(){
    System.out.println("*******************************");
    System.out.println("********* Ping/Pong ***********");
    System.out.println("********* Welcome! ************");
    System.out.println("*******************************");
  }
}
