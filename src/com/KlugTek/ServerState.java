package com.KlugTek;

/**
 * Created by akshayrajdayal on 8/10/16.
 * KlugTek Server interface
 * The server interface is an api for implementing communications over a low level generalized communication protocol
 *
 */
public interface ServerState {


    void advertise(int role);
    void listen();
    void configure(ProtocolConfig config);

    <Generic> void sendData(Generic data);

    void receiveData();

}
