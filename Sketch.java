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
  double dblBallX = 250;
  double dblBallY = 200;
  double dblBallSpeedX = 5;
  double dblBallSpeedY = 4;
  double dblBallMove = 2;

  //float value for the waves
  float fltWave;
  double dblWave;
	
	
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

    // drawing the circle
    noStroke();
    fill(255);

    // calculate Y speed of circle using sinusoidal function with periods of Pi/20 
    dblBallSpeedY = Math.sin(dblWave) * 10;
    dblWave += Math.PI/20;

    // check if circle moves beyond the edges of the window, and reverses the motion if so
    if (dblBallX - 10 < 0 || dblBallX + 10 > width) {
      dblBallSpeedX *= -1;
    } 

    if ((dblBallY - 10 < 0 && dblBallSpeedY < 0) || (dblBallY + 10 > height && dblBallSpeedY > 0)) {
      dblBallSpeedY *= -1;
      dblBallMove *= -1;
    }

    // draw + animate circle according to speeds
    ellipse((float)dblBallX, (float)dblBallY, 20, 20);
    dblBallX += dblBallSpeedX;
    dblBallY += dblBallMove + dblBallSpeedY;
  }


}