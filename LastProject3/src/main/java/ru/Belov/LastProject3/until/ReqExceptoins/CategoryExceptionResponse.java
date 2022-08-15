package ru.Belov.LastProject3.until.ReqExceptoins;

public class CategoryExceptionResponse {
    String message;

    public CategoryExceptionResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
