package com.KlugTek;

import java.nio.ByteBuffer;
import java.util.Timer;

/**
 * * Created by akshayrajdayal on 8/10/16.
 *  Klugtek ServerMachine Context (Ref. State Design Pattern)
 *
 */
public class ServerMachine {

     enum ErrorCondition {
       CONFIG,ACK,DISCONNECT
    }


    ServerState idle;
    ServerState connected;
    ServerState authorization;
    ServerState send;
    ServerState receive;
    ServerState disconnected;
    ServerState errorHandling;
    ServerState configuration;

    ServerState serverState;

    ProtocolConfig config = null;

    int machineType = 0 ; // 0:Server 1:client

    /**
     * ByteBuffer for storing the data to be sent to the client/server. The idea is to take data from
     * user through the send/receive api , add it to the byteBuffer along with its metadata. The {@link Packet} class
     * will then package data to be sent through low level communication protocol.
     */
    ByteBuffer sendBuffer;
    ByteBuffer receiveBuffer;

    /**
     * The kind of error encountered during protocol operation
     */
    Error errorType;

    /**
     * Used for tracking time elapsed  between acknowledgement sends
     */
    Timer countDown;

    /**
     * status flag for handshake procedure
     */
    boolean handShakeComplete = false;
    /**
     * status flag for configure procedure
     */
    boolean configured = false;
    /**
     * status flag for packet acknowledgment procedure
     */
    boolean ackReceived = false;
    boolean ackSent = false;
    /**
     * status flag for authorization procedure
     */
    boolean authorized = false;
    /**
     * status flag for error state trigger
     */
    boolean error = false;



    ServerMachine(){
        idle = new Idle(this);
        connected = new Connected(this);
        authorization = new Authorization(this);
        send = new Send(this);
        receive = new Receive(this);
        disconnected = new Disconnected(this);
        errorHandling = new ErrorHandling(this);
        configuration = new Configuration(this);

        serverState = idle;

        if( error == true){
            serverState = errorHandling;
        }

    }

    /**
     * Transition to user specified state
     * @param newServerState the new state for the server machine
     */

    void setServerState(ServerState newServerState){
        serverState = newServerState;
    }

    /**
     * Set the initial configuration for the server machine
     * @param cfg contains parameters for high level protocol specifications
     */

   public void configure(ProtocolConfig cfg){

       serverState.configure(cfg);

       /**

       try {
           config = new ProtocolConfig(cfg.packetLength, cfg.maxDataRetransmissions, cfg.acknowledgementTimeout, cfg.checksum);
           configured = true;

       }
       catch (Exception e){
           errorType=new Error(ServerMachine.ErrorCondition.CONFIG,e);
           configured =false;
           serverState = errorHandling;
       }

       **/
    }

    public void advertise(int role){
        serverState.advertise(role);
    }

    public void listen(){
        serverState.listen();
    }

    public <Generic> void sendData(Generic data){
        serverState.sendData(data);
    }

    public void receiveData(){
        serverState.receiveData();
    }

    public ServerState getIdleState() {return idle;}
    public ServerState getConnectedState(){return connected;}
    public ServerState getAuthorizationState(){return authorization;}
    public ServerState getSendState(){return send;}
    public ServerState getReceiveState(){return receive;}
    public ServerState getDisconnectedState(){return disconnected;}
    public ServerState getErrorHandlingState(){return errorHandling;}
    public ServerState getConfigurationState(){return  configuration;}



}



class Error{
    ServerMachine.ErrorCondition errorCondition;
    Exception e;
    Error(ServerMachine.ErrorCondition ec,Exception e){
        this.errorCondition = ec;
        this.e = e;
    }
}
