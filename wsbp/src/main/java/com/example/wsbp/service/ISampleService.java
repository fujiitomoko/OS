package com.example.wsbp.service;


import java.util.Random;

public interface ISampleService {

    public String makeCurrentHMS();

    /**
     * @return 0~9の整数で乱数を返す
     */
    public int makeRandInt();

}
