package ro.usv.rf;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class MainClass {

	public static void main(String[] args) {
			ArrayList<Entry> learningSet = null;
			try {
				learningSet = FileUtilsForIris.readLearningSetFromFile("set.txt");
			} catch (USVInputFileCustomException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			for( Entry e:learningSet) {
				System.out.println(e.displayFeatures());
			}
			Cassifier c1 = new Cassifier(learningSet);
			c1.showEntries();
	}

}
