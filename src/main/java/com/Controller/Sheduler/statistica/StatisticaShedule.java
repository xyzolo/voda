package com.Controller.Sheduler.statistica;

import com.Controller.Statistica.statistica;

import java.time.LocalDateTime;
import java.util.TimerTask;

/**
 * Created by xsd on 21.07.2017 with love.
 * :)
 *
 * @author xsd
 * @author alekseysavin.com
 * @version 0.1
 */
public class StatisticaShedule extends TimerTask {
    @Override
    public void run() {
        //send message about eating and sleeping
        try {
            LocalDateTime now = LocalDateTime.now();
            int timeOfShedule = 23;
            int currentHour = now.getHour();
            statistica bot = new statistica();
            int[] notifyHours = {7, 9, 11, 13, 15, 17, 19, 21, 23};
            for (int nH : notifyHours) {
                
                if (currentHour == nH) {
bot.sendTextToIdMessage(bot.getOwnerId(), "Это оповещение настроено на " + timeOfShedule + ", а сейчас " + currentHour);                    bot.sendMessageToThisGroupId();
                }
            }
        } catch (Exception e) {
            System.out.println();
        }
    }
}