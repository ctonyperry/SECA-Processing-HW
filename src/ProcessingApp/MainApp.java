package ProcessingApp;

import processing.core.PApplet;
import processing.core.PImage;
import processing.*;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;


public class MainApp extends PApplet{

    PImage snare;
    PImage kick;
    PImage hat;
    PImage tom;

    static String kickSoundFile = "src/data/sounds/kick.wav";
    static String snareSoundFile = "src/data/sounds/snare.wav";
    static String hatSoundFile = "src/data/sounds/hat.wav";
    static String tomSoundFile = "src/data/sounds/tom.wav";

    public void settings(){
        //surface.setResizable(true);
        size(400, 400);

    }

    public void setup(){
         snare = loadImage("images/snare.jpg");
         kick = loadImage("images/kick.jpg");
         hat = loadImage("images/hat.jpg");
         tom = loadImage("images/tom.jpg");

         snare.resize(200,200);
         kick.resize(200,200);
         hat.resize(200,200);
         tom.resize(200,200);
    }

    public void draw(){

        if(mouseX<200&&mouseY<200) {
            tint(255,0,0);
        } else{
            tint(255,255,255);
        }
        image(kick,0,0);


        if(mouseX>200&&mouseY<200) {
            tint(255,127,80);
        } else{
            tint(255,255,255);
        }
        image(snare,200,0);


        if(mouseX<200&&mouseY>200) {
            tint(0,255,0);
        } else{
            tint(255,255,255);
        }
        image(hat, 0,200);


        if(mouseX>200&&mouseY>200) {
            tint(0,0,255);
        } else{
            tint(255,255,255);
        }
        image(tom, 200,200);


    }

    public void mousePressed(){
        if(mouseX<200 && mouseY<200){
            //play kick
           playSound(kickSoundFile);
        }
        if(mouseX>200 && mouseY<200){
            //play snare
            playSound(snareSoundFile);
        }
        if(mouseX<200 && mouseY>200){
            //play hat
            playSound(hatSoundFile);
        }
        if(mouseX>200 && mouseY>200){
            //play tom
            playSound(tomSoundFile);
        }
    }
    public static void main(String[] args){
        PApplet.main("ProcessingApp.MainApp", args);

    }


    static void playSound(String soundFile){
        InputStream in = null;
        try {
            in = new FileInputStream(soundFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        AudioStream audioStream = null;
        try {
            audioStream = new AudioStream(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
        AudioPlayer.player.start(audioStream);
    }

}

