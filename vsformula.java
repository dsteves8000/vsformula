public class vsformula
{
   public static void main(String [] args)
   {
      //int [] scores = {4000, 5000};             //2 Players
      //int [] scores = {4000, 5000, 6000};       //3 Players
      int [] scores = {4000, 5000, 6000, 7000}; //4 Players
      double [] gl = gainloss(scores);
      if(scores.length == 2)
      {
         System.out.println("P1: " + gl[0] + " \nP2: " + gl[1] + " \nGive Up: " + gl[gl.length-1] + " \nDC: " + 1.5*gl[gl.length-1]);
      }
      if(scores.length == 3)
      {
         System.out.println("P1: " + gl[0] + " \nP2: " + gl[1] + " \nP3: " + gl[2] + " \nGive Up: " + gl[gl.length-1] + " \nDC: " + 1.5*gl[gl.length-1]);
      }
      if(scores.length == 4)
      {
         System.out.println("P1: " + gl[0] + " \nP2: " + gl[1] + " \nP3: " + gl[2] + " \nP4: " + gl[3] + " \nGive Up: " + gl[gl.length-1] + " \nDC: " + 1.5*gl[gl.length-1]);
      }
   }
   public static double [] gainloss(int [] scores)
   {
       double [] gl = new double [scores.length+1];
       if(scores.length >= 2 && scores.length <= 4)
       {
          int yR = scores[0];//yourRating
          double bG = 50.0;  //baseGain
          double bL = 5.0;   //baseLoss
          if(yR >= 1000){bG = 40.0; bL = 15.0;}
          if(yR >= 2000){bG = 20.0; bL = 18.0;}
          if(yR >= 3000){bG = 15.0; bL = 15.0;}
          if(yR >= 4000){bG = 8.0; bL = 8.0;}
          if(yR >= 4100){bL = 9.0;}
          if(yR >= 4500){bG = 7.0;}
          if(yR >= 5000){bG = 6.0; bL = 8.0;}
          if(yR >= 5500){bG = 5.0; bL = 7.0;}
          if(yR >= 6000){bG = 4.0; bL = 6.0;}
          if(yR >= 6500){bG = 3.0;}
          if(yR >= 7000){bL = 19.0/3.0;}
          if(yR >= 7100){bL = 20.0/3.0;}
          if(yR >= 7200){bL = 21.0/3.0;}
          if(yR >= 7300){bL = 22.0/3.0;}
          if(yR >= 7400){bL = 23.0/3.0;}
          if(yR >= 7500){bL = 24.0/3.0;}
          if(yR >= 7600){bL = 25.0/3.0;}
          if(yR >= 7700){bL = 26.0/3.0;}
          if(yR >= 7800){bL = 27.0/3.0;}
          if(yR >= 7900){bL = 28.0/3.0;}
          if(yR >= 8000){bG = 0.0; bL = 29.0/3.0;}
          gl[0] = 2 * bG * (1 - (1 / (1 + Math.pow(10, ((double) scores[1] - (double) yR) / 4000.0))));
          gl[1] = 2 * bL * (1 / (1 + Math.pow(10, (( (double) scores[1] - (double) yR) / 4000.0))));
          gl[gl.length-1] = gl[1];
          gl[1] *= -1;
          if(scores.length >= 3)
          {
            gl[0] += 2 * bG * (1 - (1 / (1 + Math.pow(10, ((double) scores[2] - (double) yR) / 4000.0))));
            gl[2] = 2 * bL * (1 / (1 + Math.pow(10, (( (double) scores[2] - (double) yR) / 4000.0))));
            gl[gl.length-1] += gl[2];
            gl[2] *= -1;
          }
          if(scores.length == 4)
          {
            gl[0] += 2 * bG * (1 - (1 / (1 + Math.pow(10, ((double) scores[3] - (double) yR) / 4000.0))));
            gl[3] = 2 * bL * (1 / (1 + Math.pow(10, (( (double) scores[3] - (double) yR) / 4000.0))));
            gl[gl.length-1] += gl[3];
            gl[3] *= -1;
          }
          gl[gl.length-1] /= (scores.length-1); gl[gl.length-1]*=-1;
       }
       return gl;
   }
}