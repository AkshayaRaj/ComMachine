package com.KlugTek;

/**
 * Created by akshayrajdayal on 8/11/16.
 */
public class Disconnected implements ServerState {

    ServerMachine serverMachine;

    public Disconnected(ServerMachine newServerMachine){serverMachine = newServerMachine;}

    @Override
    public void advertise(int role) {

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
