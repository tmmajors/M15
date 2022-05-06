package com.company.FinalProject.Weather;

public class WeatherResponse {

    public String name;
    public String base;
    public double timezone;
    public double dt;
    public double visibility;
    public int id;
    public int cod;
    public WeatherCoordinates coord;
    public Conditions weather;
    public Temperature main;
    public Wind wind;
    public Clouds clouds;
    public SystemInfo sys;

    //getters + setters
    public String getName() {return name;}

    public void setName(String name) {this.name = name;}

    public String getBase() {return base;}

    public void setBase(String base) {this.base = base;}

    public double getTimezone() {return timezone;}

    public void setTimezone(double timezone) {this.timezone = timezone;}

    public double getDt() {return dt;}

    public void setDt(double dt) {this.dt = dt;}

    public double getVisibility() {return visibility;}

    public void setVisibility(double visibility) {this.visibility = visibility;}

    public int getId() {return id;}

    public void setId(int id) {this.id = id;}

    public int getCod() {return cod;}

    public void setCod(int cod) {this.cod = cod;}

    public WeatherCoordinates getCoord() {return coord;}

    public void setCoord(WeatherCoordinates coord) {this.coord = coord;}

    public Conditions getWeather() {return weather;}

    public void setWeather(Conditions weather) {this.weather = weather;}

    public Temperature getMain() {return main;}

    public void setMain(Temperature main) {this.main = main;}

    public Wind getWind() {return wind;}

    public void setWind(Wind wind) {this.wind = wind;}

    public Clouds getClouds() {return clouds;}

    public void setClouds(Clouds clouds) {this.clouds = clouds;}

    public SystemInfo getSys() {return sys;}

    public void setSys(SystemInfo sys) {this.sys = sys;}
}
