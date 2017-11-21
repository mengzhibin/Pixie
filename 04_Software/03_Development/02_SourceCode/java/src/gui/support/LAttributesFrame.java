/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.support;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * A class containing the attributes specific to the frame.
 *
 * @author Olimpia Popica
 */
public class LAttributesFrame implements Serializable {

    /**
     * The list of attributes for the frame illumination.
     */
    private ArrayList<String> illuminationList;

    /**
     * The list of attributes for the frame weather.
     */
    private ArrayList<String> weatherList;

    /**
     * The list of attributes for the frame road type.
     */
    private ArrayList<String> roadTypeList;

    /**
     * The list of attributes for the frame road event.
     */
    private ArrayList<String> roadEventList;

    /**
     * The list of attributes for the country.
     */
    private ArrayList<String> countryList;
    
    /**
     * Serial class version in form of MAJOR_MINOR_BUGFIX_DAY_MONTH_YEAR
     */
    private static final long serialVersionUID = 0x00_01_01_05_06_2017L;

    /**
     * Instantiates a new L attributes frame.
     */
    public LAttributesFrame() {
        illuminationList = new ArrayList<>();
        weatherList = new ArrayList<>();
        roadTypeList = new ArrayList<>();
        roadEventList = new ArrayList<>();
        countryList = new ArrayList<>();
    }

    /**
     * Gets illumination list.
     *
     * @return the illumination list
     */
    public ArrayList<String> getIlluminationList() {
        return illuminationList;
    }

    /**
     * Sets illumination list.
     *
     * @param illuminationList the illumination list
     */
    public void setIlluminationList(ArrayList<String> illuminationList) {
        this.illuminationList = illuminationList;
    }

    /**
     * Gets weather list.
     *
     * @return the weather list
     */
    public ArrayList<String> getWeatherList() {
        return weatherList;
    }

    /**
     * Sets weather list.
     *
     * @param weatherList the weather list
     */
    public void setWeatherList(ArrayList<String> weatherList) {
        this.weatherList = weatherList;
    }

    /**
     * Gets road type list.
     *
     * @return the road type list
     */
    public ArrayList<String> getRoadTypeList() {
        return roadTypeList;
    }

    /**
     * Sets road type list.
     *
     * @param roadTypeList the road type list
     */
    public void setRoadTypeList(ArrayList<String> roadTypeList) {
        this.roadTypeList = roadTypeList;
    }

    /**
     * Gets road event list.
     *
     * @return the road event list
     */
    public ArrayList<String> getRoadEventList() {
        return roadEventList;
    }

    /**
     * Sets road event list.
     *
     * @param roadEventList the road event list
     */
    public void setRoadEventList(ArrayList<String> roadEventList) {
        this.roadEventList = roadEventList;
    }

    /**
     * Gets country list.
     *
     * @return the country list
     */
    public ArrayList<String> getCountryList() {
        return countryList;
    }

    /**
     * Sets country list.
     *
     * @param countryList the country list
     */
    public void setCountryList(ArrayList<String> countryList) {
        this.countryList = countryList;
    }
}
