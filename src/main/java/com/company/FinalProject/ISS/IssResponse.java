package com.company.FinalProject.ISS;

public class IssResponse {

    public IssCoordinates iss_position;
    public int timestamp;
    public String message;

    //getters + setters
    public IssCoordinates getIss_position() {return iss_position;}

    public void setIss_position(IssCoordinates iss_position) {this.iss_position = iss_position;}

    public int getTimestamp() {return timestamp;}

    public void setTimestamp(int timestamp) {this.timestamp = timestamp;}

    public String getMessage() {return message;}

    public void setMessage(String message) {this.message = message;}
}
