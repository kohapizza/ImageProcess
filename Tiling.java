
import java.awt.*;

public class Tiling {

    static MyImage execute(MyImage input1, MyImage input2) {

        int width1 = input1.width;
        int width2 = input2.width;
        int height1 = input1.height;
        int height2 = input2.height;

        int width = width1 + width2; //横に並べる
        int height = (height1 > height2) ? height1 : height2;

        MyImage output = new MyImage(width, height);

        // input1を左に配置
        for (int i = 0; i < height1; i++) {
            for (int j = 0; j < width1; j++) {
                Color color1 = input1.getColor(j, i);
                output.setColor(j, i, color1);
            }
        }

        // input2を右に配置
        for (int i = 0; i < height2; i++) {
            for (int j = 0; j < width2; j++) {
                Color color2 = input2.getColor(j, i);
                output.setColor(j + width1, i, color2);
            }
        }

        return output;
    }
}
