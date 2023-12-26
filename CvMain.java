
public class CvMain {


	static void imageProcessing1() {

		String filename1 = "walls/white.jpg";

		String filename2 = "walls/bigWine.jpg";

		String filename13 = "walls/winered.jpg";

		MyImage image1, image2;
	
		image1 = JpegFileReader.read(filename13);

		{
			//image2 = Negative.execute(image1);
			//image2 = Binalization.execute(image1);
			image2 = GammaCorrection.execute(image1, 2.0, 1.0, 1.0);
			//image2 = SpaceFiltering.execute(image1);	
			//image2 = Scale.execute(image1, 2.0, 2.0);
		    //image2 = Rotation.execute(image1);
		}

		JpegFileWriter.write(filename2, image2);

	}


	static void imageProcessing2() {

		//String filename1 = "girl1.jpg";
		String filename2 = "walls/copy2.jpg";
		// String filename11 = "pink_girl1.jpg";
		
		String filename3 = "fruits/pic0.jpg";
		String filename4 = "fruits/pic1.jpg";
		String filename5 = "fruits/pic2.jpg";
		String filename6 = "fruits/pic3.jpg";
		String filename7 = "fruits/pic4.jpg";
		String filename8 = "fruits/pic5.jpg";
		String filename9 = "fruits/pic6.jpg";
		String filename10 = "fruits/pic7.jpg";
		String filename11 = "fruits/pic8.jpg";
		String filename16 = "fruits/pic9.jpg";
		String filename17 = "fruits/pic10.jpg";

		String filename13 = "walls/winered.jpg";
		// String filename14 = "pink2.jpg";
		String filename15 = "walls/copy.jpg";
		String filename18 = "walls/bigWine.jpg";

		

		MyImage image13, image03, image14, image04, image15, image05, image16, image06, image17, image07, image18, image08, image19, image09,
		image110, image010, image111, image011, image116, image016, image117, image017, image2, image3;

		//pic0
		KMeans kmeans = new KMeans();
		image13 = JpegFileReader.read(filename3);
		kmeans.clustering(image13, 7); //int n:画像に使われる色数
		image03 = Chromakey.execute(image13, kmeans, 6);

		//pic1
		image14 = JpegFileReader.read(filename4);
		kmeans.clustering(image14, 6); //int n:画像に使われる色数
		image04 = Chromakey.execute(image14, kmeans, 3);

		//pic2
		image15 = JpegFileReader.read(filename5);
		kmeans.clustering(image15, 6); //int n:画像に使われる色数
		image05 = Chromakey.execute(image15, kmeans, 3);

		//pic3
		image16 = JpegFileReader.read(filename6);
		kmeans.clustering(image16, 6); //int n:画像に使われる色数
		image06 = Chromakey.execute(image16, kmeans, 3);

		//pic4
		image17 = JpegFileReader.read(filename7);
		kmeans.clustering(image17, 6); //int n:画像に使われる色数
		image07 = Chromakey.execute(image17, kmeans, 3);

		//pic5
		image18 = JpegFileReader.read(filename8);
		kmeans.clustering(image18, 6); //int n:画像に使われる色数
		image08 = Chromakey.execute(image18, kmeans, 3);

		//pic6
		image19 = JpegFileReader.read(filename9);
		kmeans.clustering(image19, 3); //int n:画像に使われる色数
		image09 = Chromakey.execute(image19, kmeans, 2);

		//pic7
		image110 = JpegFileReader.read(filename10);
		kmeans.clustering(image110, 6); //int n:画像に使われる色数
		image010 = Chromakey.execute(image110, kmeans, 3);

		//pic8
		image111 = JpegFileReader.read(filename11);
		kmeans.clustering(image111, 6); //int n:画像に使われる色数
		image011 = Chromakey.execute(image111, kmeans, 3);

		//pic9
		image116 = JpegFileReader.read(filename16);
		kmeans.clustering(image116, 6); //int n:画像に使われる色数
		image016 = Chromakey.execute(image116, kmeans, 3);

		//pic10
		image117 = JpegFileReader.read(filename17);
		kmeans.clustering(image117, 6); //int n:画像に使われる色数
		image017 = Chromakey.execute(image117, kmeans, 3);


		image2 = JpegFileReader.read(filename18);

		MyImage[] fruitsArr1 = {image13, image14, image15, image16, image17, image18, image19, image110, image111, image116, image117};
		MyImage[] fruitsArr0 = {image03, image04, image05, image06, image07, image08, image09, image010, image011, image016, image017};

		MyImage[] bigfruitsArr1 = new MyImage[11];
		MyImage[] bigfruitsArr0 = new MyImage[11];

		//いちご、キウイ、葉っぱでかくする
		//元画像を拡大
		for(int k = 0; k<=10; k++){
			if(k == 2 || k == 3 || k == 8 || k == 10){
				bigfruitsArr0[k] = Scale.execute(fruitsArr0[k], 3.5, 3.5);
				bigfruitsArr1[k] = Scale.execute(fruitsArr1[k], 3.5, 3.5);
			}else{
				bigfruitsArr0[k] = Scale.execute(fruitsArr0[k], 2.5, 2.5);
				bigfruitsArr1[k] = Scale.execute(fruitsArr1[k], 2.5, 2.5);
			}
		}

		for(int j = 0; j <= 18; j++){
			
			for(int i = 0; i <= 10; i++){
				if(j%3 == 0){
					bigfruitsArr0[i] = Scale.execute(bigfruitsArr0[i], 0.9, 0.9);
					bigfruitsArr1[i] = Scale.execute(bigfruitsArr1[i], 0.9, 0.9);
				}
				if(j%3 == 1){
					bigfruitsArr0[i] = Rotation.execute(bigfruitsArr0[i]);
					bigfruitsArr1[i] = Rotation.execute(bigfruitsArr1[i]);
				}
				
					image3 = VirtualStudioRandom.execute(bigfruitsArr1[i], image2, bigfruitsArr0[i]);
					JpegFileWriter.write(filename15, image3);
					image2 = JpegFileReader.read(filename15);
			}
		}

		// image3 = VirtualStudio.execute(image117, image2, image017);
		// JpegFileWriter.write(filename15, image3);
		//image3 = AlphaBlending2.execute(image1, image2, image0);
		//image3 = Tiling.execute(image1, image2);



	}

	static void imageProcessing3(){ //中の画像を作る
		String filename1 = "walls/yellow.jpg";
		String filename2 = "walls/white.jpg";
		String filename3 = "girl/girl2.jpg";
		String filename4 = "girl/girl3.jpg";
		String filename5 = "girl/girl4.jpg";
		String filename6 = "walls/miniCopy.jpg";

		//output
		String filename10 = "processed_girls/yellow_girl4.jpg";
		String filename11 = "processed_girls/white_girl3.jpg";

		String filename13 = "processed_girls/gum_white_girl3.jpg";
		String filename14 = "processed_girls/gum2_white_girl3.jpg";

		String filename15 = "processed_girls/flower_girl2.jpg";

		MyImage image11, image01, image12, image02, image13, image03, image14, image04, image15, image05, image16, image06, image17, image07, image2, image3, image4, image5, 
		image115, image015, image116, image016, image117, image017, image6, image7, image8, image9;

		image2 = JpegFileReader.read(filename1);
		image5 = JpegFileReader.read(filename2);
		image9 = JpegFileReader.read(filename6);

		//yellow * girl4
		KMeans kmeans = new KMeans();
		image15 = JpegFileReader.read(filename5);
		kmeans.clustering(image15, 6); //int n:画像に使われる色数
		image05 = Chromakey.execute(image15, kmeans, 2);

		//white * girl3
		image16 = JpegFileReader.read(filename4);
		kmeans.clustering(image16, 6); //int n:画像に使われる色数
		image06 = Chromakey.execute(image16, kmeans, 2);

		//flower * girl2
		image17 = JpegFileReader.read(filename3);
		kmeans.clustering(image17, 6); //int n:画像に使われる色数
		image07 = Chromakey.execute(image17, kmeans, 2);

		image115 =  Scale.execute(image15, 1.3, 1.3);
		image015 =  Scale.execute(image05, 1.3, 1.3);

		image116 =  Scale.execute(image16, 1.3, 1.3);
		image016 =  Scale.execute(image06, 1.3, 1.3);

		image117 =  Scale.execute(image17, 1.4, 1.4);
		image017 =  Scale.execute(image07, 1.4, 1.4);
		
		image3 = VirtualStudioSelect.execute(image115, image2, image015, 45, 0); //縦,横
		image4 = VirtualStudioSelect.execute(image116, image5, image016, 25, -200); //縦,横
		image6 = VirtualStudioSelect.execute(GammaCorrection.execute(image116, 2.0, 1.0, 1.0), image4, GammaCorrection.execute(image016, 2.0, 1.0, 1.0), 45, -55); //縦,横
		image7 = VirtualStudioSelect.execute(GammaCorrection.execute(image116, 2.0, 0.5, 0.5), image6, GammaCorrection.execute(image016, 2.0, 0.5, 0.5), 65, 90); //縦,横
		image8 = VirtualStudioSelect.execute(image117, image9, image017, 25, -200); //縦,横

		JpegFileWriter.write(filename10, image3);
		JpegFileWriter.write(filename11, image4);
		JpegFileWriter.write(filename13, image6);
		JpegFileWriter.write(filename14, image7);
		JpegFileWriter.write(filename15, image8);



	}

	static void imageProcessing4(){ //1/3作る
		String filename1 = "walls/copy3.jpg";
		String filename2 = "processed_girls/yellow_girl4.jpg";
		String filename6 = "processed_girls/gum2_white_girl3.jpg";
		String filename7 = "walls/bigyellow.jpg";
		String filename9 = "processed_girls/flower_girl2.jpg";
		String filename10 = "walls/bigwhite.jpg"; 

		//output
		String filename3 = "output1.jpg";
		String filename4 = "output2.jpg";
		String filename5 = "output3.jpg";

		String filename8 = "walls/miniCopy.jpg";

		MyImage image1, image2, image3, image4, image5, image6, image7, image8, image9;

		image1 = JpegFileReader.read(filename1);
		image2 = JpegFileReader.read(filename2);
		image4 = JpegFileReader.read(filename6);
		image5 = JpegFileReader.read(filename7);
		image7 = JpegFileReader.read(filename9);
		image8 = JpegFileReader.read(filename10);

		image3 = Scale.execute(image1, 0.5, 0.5); //copy3を1/2に(壁紙1/3大きさに)
		// JpegFileWriter.write(filename8, image3);

		image3 = VirtualStudioSimple.execute(image2, image3, 100, 100);
		image6 = VirtualStudioSimple.execute(image4, image5, 100, 100);
		image9 = VirtualStudioSimple.execute(image7, image8, 100, 100);
		

		JpegFileWriter.write(filename3, image3);
		JpegFileWriter.write(filename4, image6);
		JpegFileWriter.write(filename5, image9);

	}

	static void imageProcessing5(){ //3枚を並べる
		String filename1 = "output1.jpg";
		String filename2 = "output2.jpg";
		String filename3 = "output3.jpg";

		//output
		String filename4 = "final_output.jpg";

		MyImage image1, image2, image3, image4, image5;

		image1 = JpegFileReader.read(filename1);
		image2 = JpegFileReader.read(filename2);
		image3 = JpegFileReader.read(filename3);


		image4 = Tiling.execute(image1, image2); //タイリング1回目

		image5 = Tiling.execute(image4, image3); //タイリング2回目

		JpegFileWriter.write(filename4, image5);
	}


	public static void main(String args[]) {

		
		//imageProcessing1();
		//imageProcessing2();
		//imageProcessing3();
		//imageProcessing4();
		imageProcessing5();

	}
}
