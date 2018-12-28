import java.util.Stack;

public class LargestRectangleHistogram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] histogram = {2,4,2,1,10,6,10,15};
		System.out.println("largest area of rectange is "+largestAreaHistogram(histogram));
	}
	public static int largestAreaHistogram(int[] histogram) {
		Stack<Integer> heights = new Stack<Integer>(); // to save the heights of rectangles
		Stack<Integer> indexes = new Stack<Integer>(); // to save indexes
		int largestArea = 0;
		
		for(int i = 0 ; i< histogram.length; i++ ) {
			if (heights.isEmpty() || histogram[i] > heights.peek()) {
				heights.push(histogram[i]);
				indexes.push(i);
			}
			else if (histogram[i] < heights.peek()) {
				int lastIndex =0; // to keep the track of lastIndex
				while (!heights.isEmpty() && histogram[i] < heights.peek()) {
					lastIndex = indexes.pop();
					int recArea = heights.pop() * (i - lastIndex);
					if ( largestArea < recArea)
						largestArea = recArea;
				}
				// once done push the current element on the stack
				heights.push(histogram[i]);
				indexes.push(lastIndex);
				}
		    }
			// after the process there still might be elements on the stack which need to be computed
			while (!heights.isEmpty()) {
				int recArea = heights.pop() * (histogram.length - indexes.pop());
				if ( largestArea < recArea)
					largestArea = recArea;
			}
		return largestArea;
		}
		
		
}
