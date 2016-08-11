package com.KlugTek;

/**
 * Created by akshayrajdayal on 8/11/16.
 */
public class Idle implements ServerState {

    ServerMachine serverMachine;

    public Idle(ServerMachine newServerMachine){serverMachine = newServerMachine;}

    @Override
    public void advertise(int role) {

        if(role==0){
            if(serverMachine.configured==false){
                System.out.println("Please configure the server first");
                serverMachine.setServerState(serverMachine.getConfigurationState());
            }
            else{
                System.out.println("Advertising server..");
//                TODO handshake() with client to proceed to connected
//                if(handshake.success)
                serverMachine.setServerState(serverMachine.getConnectedState());
                System.out.println("Connected to client, please authorize");

            }
        }


    }

    @Override
    public void listen() {


    }

    @Override
    public void configure(ProtocolConfig config) {

    }

    @Override
    public <Generic> void sendData(Generic data) {

    }

    @Override
    public void receiveData() {

    }
}
