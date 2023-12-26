
import java.awt.*;
import java.util.Random;

public class VirtualStudioRandom {

    static MyImage execute(MyImage input1, MyImage input2, MyImage input0) {
        // input2 壁紙

        int width1 = input1.width;
		int width2 = input2.width;
		int height1 = input1.height;
		int height2 = input2.height;

        //mac 1440 * 990
        int width = width2;
        int height = height2;

        //System.out.println("横" + width); //1600
        //System.out.println("縦" +height); //853

        Random rand = new Random();
        int randomNumWid = (rand.nextInt(30))*150 -550;
        int randomNumHei = (rand.nextInt(30))*100 -300;

        MyImage output = new MyImage(width, height);

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                boolean isProcessed = false;

                if (i >= randomNumHei && i < height1 + randomNumHei && j >= randomNumWid && j < width1 + randomNumWid) {
                    


                    Color color0 = input0.getColor(j - randomNumWid, i - randomNumHei);
                    if (color0.getRed() > 0) {

                        Color color1 = input1.getColor(j - randomNumWid, i - randomNumHei);
                        output.setColor(j, i, color1);

                        isProcessed = true;
                    }

                    

                }

                if (i < height2 && j < width2) {
                    if (isProcessed == false) {

                        Color color2 = input2.getColor(j, i);
                        output.setColor(j, i, color2);
                    }
                }
            }
        }

        return output;
    }
}
