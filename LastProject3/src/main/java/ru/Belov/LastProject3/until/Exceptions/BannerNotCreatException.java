package ru.Belov.LastProject3.until.Exceptions;

public class BannerNotCreatException extends RuntimeException{
    String mess;

    public BannerNotCreatException( String mess) {
        super(mess);

    }
}
