package ru.Belov.LastProject3.until.Exceptions;

public class RequestWithBannerNotFoundException extends  RuntimeException{
    public RequestWithBannerNotFoundException(String mess){
        super(mess);
    }
}
