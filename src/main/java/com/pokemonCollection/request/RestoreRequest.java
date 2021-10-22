package com.pokemonCollection.request;

public class RestoreRequest {

    private String email;
    private String securityCode;
    private String newPassword;
    public RestoreRequest(String email, String securityCode) {
        this.email = email;
        this.securityCode = securityCode;
    }

    public RestoreRequest() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSecurityCode() {
        return securityCode;
    }

    public void setSecurityCode(String securityCode) {
        this.securityCode = securityCode;
    }

    @Override
    public String toString() {
        return "RestoreRequest{" +
                "email='" + email + '\'' +
                ", securityCode='" + securityCode + '\'' +
                '}';
    }
}
