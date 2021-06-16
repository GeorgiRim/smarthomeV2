package com.georgirim.smarthome.gpio;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.OrangePiPin;
import com.pi4j.platform.Platform;
import com.pi4j.platform.PlatformAlreadyAssignedException;
import com.pi4j.platform.PlatformManager;

public class MyGpio{
    private GpioController gpio ;
    private GpioPinDigitalOutput myLed;

    public MyGpio() {

        try { // с ошибками не особо пока что запариваемся только прототип же( наверное)
            PlatformManager.setPlatform(Platform.ORANGEPI);// указываем , что  работаем с OrangePI
        } catch (PlatformAlreadyAssignedException e) {
            e.printStackTrace();
        }

        gpio= GpioFactory.getInstance();
        myLed = gpio.provisionDigitalOutputPin(OrangePiPin.GPIO_08); // инициализируем 8 пин как выход
        // то есть будем управлять его напряжением
    }

    public void light(){ // метод отвечающий за свечение
        if(myLed.isHigh()) myLed.low(); // если на выбранном пине высокое напряжение сделать его равным напряжению на земле
        else myLed.high();// иначе подать высокое напряжение на выбранный пин (8)
    }

    public void blink(){ // ну и так помигать для виду
        for (int i =0;i<10;i++) {
            try {
                light();
                Thread.sleep(500);
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}