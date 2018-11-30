# PingPongBackEnd Application

An CLI application which accepts client connections and interacts with them. 

Upon server initialization the host name and the local port is printed, 
helping clients establishing a connection.

The first interaction is made by the server which pings the client when it first gets connected. 
Then it waits for a respond (a pong) from a client. When a client responds server responds back after a short period.

User may **exit the program** typing ```exit``` and press enter.

## Getting Started

This is a CLI application. Open your terminal, compile the application and execute it.

### Prerequisites

- Java SDK installed on your machine.
- A client to send pongs ([PingPongAndroidClient](https://github.com/tomasmichael995/PingPongAndroidClient) is an android app client).
- Server and client must connected to the same network.

### Known Issues

#### Wrong Host Name

On some machines the server prints its host name as ```0.0.0.0```. 
In that case consider finding the machine's address on the network that both server and clients are connected. 
This could be your local network at home (wifi).  

## Built With

* Core Java APIs. 
* Editor used, Atom.
