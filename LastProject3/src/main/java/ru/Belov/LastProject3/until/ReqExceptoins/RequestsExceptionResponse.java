package ru.Belov.LastProject3.until.ReqExceptoins;

public class RequestsExceptionResponse {

    String message;

    public RequestsExceptionResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
