package com.KlugTek;

/**
 * Created by akshayrajdayal on 8/10/16.
 */
public class ProtocolConfig {

    int packetLength = 65535; //bytes
    int maxDataRetransmissions = 5;
    int acknowledgementTimeout = 10;

    public enum Checksum {
        MD5, SHA1 , CRC32, MD6
    }
    Checksum checksum =  Checksum.MD5;


    ProtocolConfig(int packetLength,int maxDataRetransmissions, int acknowledgementTimeout, Checksum checksum){
        this.packetLength = packetLength;
        this.maxDataRetransmissions = maxDataRetransmissions;
        this.acknowledgementTimeout = acknowledgementTimeout;
        this.checksum = checksum;
    }

    public int getPacketLength() {
        return packetLength;
    }

    public void setPacketLength(int packetLength) {
        this.packetLength = packetLength;
    }

    public int getMaxDataRetransmissions() {
        return maxDataRetransmissions;
    }

    public void setMaxDataRetransmissions(int maxDataRetransmissions) {
        this.maxDataRetransmissions = maxDataRetransmissions;
    }

    public int getAcknowledgementTimeout() {
        return acknowledgementTimeout;
    }

    public void setAcknowledgementTimeout(int acknowledgementTimeout) {
        this.acknowledgementTimeout = acknowledgementTimeout;
    }

    public Checksum getChecksum() {
        return checksum;
    }

    public void setChecksum(Checksum checksum) {
        this.checksum = checksum;
    }
}
