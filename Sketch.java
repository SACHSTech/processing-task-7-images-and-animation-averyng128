/**
 * A code to display a pink back ground with a butterfly and ball bouncing in the display in a wave patter
 * Author: @A. Ng
 */

import processing.core.PApplet;
import processing.core.PImage;

public class Sketch extends PApplet {

  // declaring images 
  PImage imgBackground;
  PImage imgButterfly;

  //float values for the butterfly
  float fltButterflyx = 300;
  float fltButterflyy = 20;
  float fltButterflySpeedx = 3;
  float fltButterflySpeedy = 3;

  //float values for the ball
  float fltBallX = 250;
  float fltBallY = 200;
  float fltBallSpeedX = 5;
  float fltBallSpeedY = 4;

  //float value for the waves
  float fltWave;
	
	
  public void settings() {
    size(600, 600);
  }
  

  public void setup() {
    // sets up background image and butterfly image
    imgBackground = loadImage("v546batch3-mynt-34-badgewatercolor_1.jpg");
    imgBackground.resize(width, height);
    image(imgBackground, 0, 0);
    imgButterfly = loadImage("flying-butterflies-png-transparent.png");
    imgButterfly.resize(50,50);
  }


  public void draw() {

    //draws the background image
    image(imgBackground, 0, 0);
	
    //draws the butterfly image 
    image(imgButterfly, fltButterflyx, fltButterflyy);

    //moves the butterfly along a sine wave
    fltButterflyy += (float)(Math.sin(fltWave)) + fltButterflySpeedy;
    fltButterflyx += (float)(Math.sin(fltWave)) + fltButterflySpeedx;

    //if statements to reverse the butterfly speed if it comes too close to the boundary
    if (fltButterflyx < 0 + 3 || fltButterflyx > width - 45) {
      fltButterflySpeedx *= -1;
    }

    if (fltButterflyy < 0 + 3 || fltButterflyy > height - 45) {
      fltButterflySpeedy *= -1;
    }

    // drawing and animating a circle
    fill(255);
    ellipse(fltBallX, fltBallY, 20, 20);
    fltBallX += fltBallSpeedX;
    fltBallY += fltBallSpeedY;

    // basic edge detection between the walls
    if(fltBallX < 20 || fltBallX > width){
      fltBallSpeedX *= -1;
    }
    if(fltBallY < 10 || fltBallY > height){
      fltBallSpeedY *= -1;
	
    }
  }


}