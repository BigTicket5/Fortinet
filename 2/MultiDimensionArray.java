
public class MultiDimensionArray {
	// This is a provided function, Assume it works
    public static Long getValue(int... indexOfDimension) {
        //... 
        return value;
    }
    
    // lengthOfDeminsion: each dimension's length, assume it is valid: lengthOfDeminsion[i]>0.
    public static Long sum(MultiDimensionArray mArray, int[] lengthOfDeminsion) { 
	    // Your resolution 
	    // Time complexity: O(m*n) m is the length of the array, n is the length of the longest dimesion.
	    // Space complexity:O(1)
    	long sum = 0;
    	for(int i=0;i<lengthOfDeminsion.length;i++){
    		int len = lengthOfDeminsion[i];
    		for(int j = 0;j<len;j++){
    			sum+=getValue(j);
    		}
    	}
    	return sum;
    }
}
