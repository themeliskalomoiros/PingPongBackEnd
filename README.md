# PingPongBackEnd Application

An CLI application which accepts client connections and interacts with them. 

Upon server initialization the host name and the local port is printed, 
helping clients establishing a connection.

The first interaction is made by the server which pings the client when it first gets connected. 
Then it waits for a respond (a pong) from a client. When a client responds server responds back after a short period.

User may **exit the program** typing ```exit``` and press enter.

## Getting Started

This is a CLI application. After you've cloned the repository open a terminal, compile and execute.

### Compilation
1. Navigate to the PingPongBackEnd repository by typing in the terminal ```cd <path_to_repository>```.
2. Compile the *.java* files, ```javac -d <path_to_location_for_the_class_files> PingPongBackendApp.java```.

### Execution
To execute the program simply type the following command from anywhere```java com.skemelio.ping_pong.PingPongBackendApp``` if the *CLASSPATH* is set. 
Otherwise navigate to the PingPongBackEnd repository (as specified above in step 1) and then use the same command.

### Prerequisites

- Java SDK installed on your machine.
- A client to send pings ([PingPongAndroidClient](https://github.com/tomasmichael995/PingPongAndroidClient) is an android app client).
- Server and client must connected to the same network.

### Known Issues

#### Wrong Host Name

On some machines the server prints its host name as ```0.0.0.0```. 
In that case consider finding the machine's address on the network that both server and clients are connected. 
This could be your local network at home (wifi).  

## Built With

* Core Java APIs. 
* Editor used, Atom.
