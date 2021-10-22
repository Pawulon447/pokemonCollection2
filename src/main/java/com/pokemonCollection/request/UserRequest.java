package com.pokemonCollection.request;

public class UserRequest {
    private String email;
   private String password1;
    private String password2;

    public UserRequest(String email, String password1, String password2) {
        this.email = email;
        this.password1 = password1;
        this.password2 = password2;
    }

    public UserRequest(String email, String password1) {
        this.email = email;
        this.password1 = password1;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword1() {
        return password1;
    }

    public String getPassword2() {
        return password2;
    }

    @Override
    public String toString() {
        return "UserRequest{" +
                "email='" + email + '\'' +
                ", password1='" + password1 + '\'' +
                ", password2='" + password2 + '\'' +
                '}';
    }


}
