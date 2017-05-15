package model;

/**
 * Created by kamina on 17.04.2017.
 */

public class Weather {
    public Place place;
    public String iconData;
    public CurrentCundition currentCundition = new CurrentCundition();
    public Temperature temperature = new Temperature();
    public Wind wind = new Wind();
    public Snow snow = new Snow();
    public Clouds clouds = new Clouds();



}
