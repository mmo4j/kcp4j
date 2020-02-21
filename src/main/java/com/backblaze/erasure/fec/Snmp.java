package com.backblaze.erasure.fec;

import java.util.concurrent.atomic.LongAdder;

/**
 * Created by JinMiao
 * 2018/8/29.
 */
public class Snmp {

  public static volatile Snmp snmp = new Snmp();

  // bytes sent from upper level
  public LongAdder bytesSent = new LongAdder();

  // bytes received to upper level
  public LongAdder bytesReceived = new LongAdder();

  // max number of connections ever reached
  public LongAdder maxConnections = new LongAdder();

  // accumulated active open connections
  public LongAdder activeOpenConnections = new LongAdder();

  // accumulated passive open connections
  public LongAdder passiveOpenConnections = new LongAdder();

  // current number of established connections
  public LongAdder currentEstablishedConnections = new LongAdder();

  // UDP read errors reported from net.PacketConn
  public LongAdder incomingErrors = new LongAdder();

  // checksum errors from CRC32
  public LongAdder incomingChecksumErrors = new LongAdder();

  // packet input errors reported from KCP
  public LongAdder kcpInErrors = new LongAdder();

  // incoming packets count
  public LongAdder incomingPackets = new LongAdder();

  // outgoing packets count
  public LongAdder outgoingPackets = new LongAdder();

  // incoming KCP segments
  public LongAdder incomingSegments = new LongAdder();

  // outgoing KCP segments
  public LongAdder outgoingSegments = new LongAdder();

  // UDP bytes received
  public LongAdder incomingBytes = new LongAdder();

  // UDP bytes sent
  public LongAdder outgoingBytes = new LongAdder();

  // accumulated retransmitted segments
  public LongAdder retransmittedSegments = new LongAdder();

  // accumulated fast retransmitted segments
  public LongAdder fastRetransmittedSegments = new LongAdder();

  // accumulated early retransmitted segments
  public LongAdder earlyRetransmittedSegments = new LongAdder();

  // number of segs inferred as lost
  public LongAdder lostSegments = new LongAdder();

  // number of segs duplicated
  public LongAdder repeatedSegments = new LongAdder();

  // correct packets recovered from FEC
  public LongAdder fecRecoveredPackets = new LongAdder();

  // incorrect packets recovered from FEC
  public LongAdder fecErrorPackets = new LongAdder();

  // 收到的 Data数量
  public LongAdder fecDataShards = new LongAdder();

  // 收到的 Parity数量
  public LongAdder fecParityShards = new LongAdder();

  // number of data shards that's not enough for recovery
  public LongAdder fecShortShards = new LongAdder();

  // number of data shards that's not enough for recovery
  public LongAdder fecRepeatDataShards = new LongAdder();

  public static Snmp getSnmp() {
    return snmp;
  }

  public static void setSnmp(Snmp snmp) {
    Snmp.snmp = snmp;
  }

  public LongAdder getBytesSent() {
    return bytesSent;
  }

  public void setBytesSent(LongAdder bytesSent) {
    this.bytesSent = bytesSent;
  }

  public LongAdder getBytesReceived() {
    return bytesReceived;
  }

  public void setBytesReceived(LongAdder bytesReceived) {
    this.bytesReceived = bytesReceived;
  }

  public LongAdder getMaxConnections() {
    return maxConnections;
  }

  public void setMaxConnections(LongAdder maxConnections) {
    this.maxConnections = maxConnections;
  }

  public LongAdder getActiveOpenConnections() {
    return activeOpenConnections;
  }

  public void setActiveOpenConnections(LongAdder activeOpenConnections) {
    this.activeOpenConnections = activeOpenConnections;
  }

  public LongAdder getPassiveOpenConnections() {
    return passiveOpenConnections;
  }

  public void setPassiveOpenConnections(LongAdder passiveOpenConnections) {
    this.passiveOpenConnections = passiveOpenConnections;
  }

  public LongAdder getCurrentEstablishedConnections() {
    return currentEstablishedConnections;
  }

  public void setCurrentEstablishedConnections(LongAdder currentEstablishedConnections) {
    this.currentEstablishedConnections = currentEstablishedConnections;
  }

  public LongAdder getIncomingErrors() {
    return incomingErrors;
  }

  public void setIncomingErrors(LongAdder incomingErrors) {
    this.incomingErrors = incomingErrors;
  }

  public LongAdder getIncomingChecksumErrors() {
    return incomingChecksumErrors;
  }

  public void setIncomingChecksumErrors(LongAdder incomingChecksumErrors) {
    this.incomingChecksumErrors = incomingChecksumErrors;
  }

  public LongAdder getKcpInErrors() {
    return kcpInErrors;
  }

  public void setKcpInErrors(LongAdder kcpInErrors) {
    this.kcpInErrors = kcpInErrors;
  }

  public LongAdder getIncomingPackets() {
    return incomingPackets;
  }

  public void setIncomingPackets(LongAdder incomingPackets) {
    this.incomingPackets = incomingPackets;
  }

  public LongAdder getOutgoingPackets() {
    return outgoingPackets;
  }

  public void setOutgoingPackets(LongAdder outgoingPackets) {
    this.outgoingPackets = outgoingPackets;
  }

  public LongAdder getIncomingSegments() {
    return incomingSegments;
  }

  public void setIncomingSegments(LongAdder incomingSegments) {
    this.incomingSegments = incomingSegments;
  }

  public LongAdder getOutgoingSegments() {
    return outgoingSegments;
  }

  public void setOutgoingSegments(LongAdder outgoingSegments) {
    this.outgoingSegments = outgoingSegments;
  }

  public LongAdder getIncomingBytes() {
    return incomingBytes;
  }

  public void setIncomingBytes(LongAdder incomingBytes) {
    this.incomingBytes = incomingBytes;
  }

  public LongAdder getOutgoingBytes() {
    return outgoingBytes;
  }

  public void setOutgoingBytes(LongAdder outgoingBytes) {
    this.outgoingBytes = outgoingBytes;
  }

  public LongAdder getRetransmittedSegments() {
    return retransmittedSegments;
  }

  public void setRetransmittedSegments(LongAdder retransmittedSegments) {
    this.retransmittedSegments = retransmittedSegments;
  }

  public LongAdder getFastRetransmittedSegments() {
    return fastRetransmittedSegments;
  }

  public void setFastRetransmittedSegments(LongAdder fastRetransmittedSegments) {
    this.fastRetransmittedSegments = fastRetransmittedSegments;
  }

  public LongAdder getEarlyRetransmittedSegments() {
    return earlyRetransmittedSegments;
  }

  public void setEarlyRetransmittedSegments(LongAdder earlyRetransmittedSegments) {
    this.earlyRetransmittedSegments = earlyRetransmittedSegments;
  }

  public LongAdder getLostSegments() {
    return lostSegments;
  }

  public void setLostSegments(LongAdder lostSegments) {
    this.lostSegments = lostSegments;
  }

  public LongAdder getRepeatedSegments() {
    return repeatedSegments;
  }

  public void setRepeatedSegments(LongAdder repeatedSegments) {
    this.repeatedSegments = repeatedSegments;
  }

  public LongAdder getFecRecoveredPackets() {
    return fecRecoveredPackets;
  }

  public void setFecRecoveredPackets(LongAdder fecRecoveredPackets) {
    this.fecRecoveredPackets = fecRecoveredPackets;
  }

  public LongAdder getFecErrorPackets() {
    return fecErrorPackets;
  }

  public void setFecErrorPackets(LongAdder fecErrorPackets) {
    this.fecErrorPackets = fecErrorPackets;
  }

  public LongAdder getFecDataShards() {
    return fecDataShards;
  }

  public void setFecDataShards(LongAdder fecDataShards) {
    this.fecDataShards = fecDataShards;
  }

  public LongAdder getFecParityShards() {
    return fecParityShards;
  }

  public void setFecParityShards(LongAdder fecParityShards) {
    this.fecParityShards = fecParityShards;
  }

  public LongAdder getFecShortShards() {
    return fecShortShards;
  }

  public void setFecShortShards(LongAdder fecShortShards) {
    this.fecShortShards = fecShortShards;
  }

  public LongAdder getFecRepeatDataShards() {
    return fecRepeatDataShards;
  }

  public void setFecRepeatDataShards(LongAdder fecRepeatDataShards) {
    this.fecRepeatDataShards = fecRepeatDataShards;
  }

  @Override
  public String toString() {
    return "Snmp{" +
           "bytesSent=" + bytesSent +
           ", bytesReceived=" + bytesReceived +
           ", maxConnections=" + maxConnections +
           ", activeOpenConnections=" + activeOpenConnections +
           ", passiveOpenConnections=" + passiveOpenConnections +
           ", currentEstablishedConnections=" + currentEstablishedConnections +
           ", incomingErrors=" + incomingErrors +
           ", incomingChecksumErrors=" + incomingChecksumErrors +
           ", kcpInErrors=" + kcpInErrors +
           ", incomingPackets=" + incomingPackets +
           ", outgoingPackets=" + outgoingPackets +
           ", incomingSegments=" + incomingSegments +
           ", outgoingSegments=" + outgoingSegments +
           ", incomingBytes=" + incomingBytes +
           ", outgoingBytes=" + outgoingBytes +
           ", retransmittedSegments=" + retransmittedSegments +
           ", fastRetransmittedSegments=" + fastRetransmittedSegments +
           ", earlyRetransmittedSegments=" + earlyRetransmittedSegments +
           ", lostSegments=" + lostSegments +
           ", repeatedSegments=" + repeatedSegments +
           ", fecRecoveredPackets=" + fecRecoveredPackets +
           ", fecErrorPackets=" + fecErrorPackets +
           ", fecDataShards=" + fecDataShards +
           ", fecParityShards=" + fecParityShards +
           ", fecShortShards=" + fecShortShards +
           ", fecRepeatDataShards=" + fecRepeatDataShards +
           '}';
  }
}
