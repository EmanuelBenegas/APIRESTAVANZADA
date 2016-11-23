package Apirest.responses;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by lcc on 23/11/2016.
 */
public class LoginResponseWrapper {
    @JsonProperty
    String sessionid;

    public LoginResponseWrapper() {

    }

    public LoginResponseWrapper(String sessionId) {

        this.sessionid = sessionId;
    }

    public String getSessionId() {

        return sessionid;
    }

    public void setSessionId(String sessionId) {

        this.sessionid = sessionId;
    }
}
