# PingPongBackEnd

PingPongBackEnd is a Command Line Interface (CLI) application designed to accept client connections and engage in interactive communication with them.

Upon server initialization, the host name and the local port are printed, facilitating client connection establishment.

The first interaction is initiated by the server, which pings the client upon the initial connection. Subsequently, it awaits a response (a pong) from the client. When a client responds, the server reciprocates after a short period.

## Getting Started

This is a CLI application. After cloning the repository, open a terminal, compile, and execute.

### Compilation
1. Navigate to the PingPongBackEnd repository by entering the following command in the terminal: ```cd <path_to_repository>```.
2. Compile the *.java* files using: ```javac -d <path_to_location_for_the_class_files> PingPongBackendApp.java```.

### Execution
To execute the program, type the following command from anywhere: ```java com.skemelio.ping_pong.PingPongBackendApp``` if the *CLASSPATH* is set. If not, navigate to the PingPongBackEnd repository (as specified above in step 1) and use the same command.

### Prerequisites

- Java SDK installed on your machine.
- A client to send pings ([PingPongAndroidClient](https://github.com/tomasmichael995/PingPongAndroidClient), an Android app client).
- Server and client must be connected to the same network.

### Known Issues

#### Wrong Host Name

On some machines, the server may print its host name as ```0.0.0.0```. In that case, consider finding the machine's address on the network that both the server and clients are connected to. This could be your local network at home (Wi-Fi).  
