
import java.awt.*;


public class VirtualStudioSimple {

	static MyImage execute(MyImage input1, MyImage input2, int a, int b) { 
		//input1 : topimage

		int width1 = input1.width;
		int width2 = input2.width;
		int height1 = input1.height;
		int height2 = input2.height;
	
		// int width  = (width1  > width2)  ? width1  : width2;
		// int height = (height1 > height2) ? height1 : height2;

		int width = width2; //壁紙が大きさの軸で固定
		int height = height2;


		MyImage output = new MyImage(width, height);

		for(int i = 0; i < height; i++) {
			for(int j = 0; j < width; j++) {
				boolean isProcessed = false;
		
				if(i >= a && i < height1 + a && j >= b && j < width1 + b) {

					// Color color0 = input0.getColor(j - b, i - a);
					// if(color0.getRed() > 0) {
				
						Color color1 = input1.getColor(j - b, i - a);
						output.setColor(j, i, color1);
				
						isProcessed = true;
					// }
					
				}

				if(i < height2 && j < width2) {
					if(isProcessed == false) {
						
						Color color2 = input2.getColor(j, i);
						output.setColor(j, i, color2);
					}
				}
			}
		}

		return output;

	}

}
