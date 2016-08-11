package com.KlugTek;

/**
 * Created by akshayrajdayal on 8/11/16.
 */
public class Send implements ServerState {

    ServerMachine serverMachine;

    public Send(ServerMachine newServerMachine){serverMachine = newServerMachine;}

    @Override
    public void advertise(int role) {
        System.out.println("Machine is already setup as " + serverMachine.machineType );

    }

    @Override
    public void listen() {


    }

    @Override
    public void configure(ProtocolConfig config) {
        System.out.println("Configured already");

    }

    @Override
    public <Generic> void sendData(Generic data) {
        //we are assuming server sends data (write to file)


       // if(serverMachine.ackReceived == false)

    }

    @Override
    public void receiveData() {

    }
}
