package dhirajnayak.com.layer3assignment.model;

/**
 * Created by dhirajnayak on 1/20/18.
 * model for parameters to be sent as post request
 */

public class BodyParams {
    private String text;
    private String deviceID;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getDeviceID() {
        return deviceID;
    }

    public void setDeviceID(String deviceID) {
        this.deviceID = deviceID;
    }
}
