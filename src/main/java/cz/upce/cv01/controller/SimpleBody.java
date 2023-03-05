package cz.upce.cv01.controller;

public class SimpleBody {
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "SimpleBody{" +
                "message='" + message + '\'' +
                '}';
    }

    public SimpleBody(String message) {
        this.message = message;
    }

    private String message;
}
