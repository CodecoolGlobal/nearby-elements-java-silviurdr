import java.util.Arrays;

public class NearbyElements {


    // the two-dimensional arrray with the data
    private static int[][] multi = new int[][] {

            { 2, 0, 4, 1241, 12, 5, 11, 1110, -42, 424, 1, 12323 },
            { 1, 3, 5, 7 },
            { 321, 320, 32, 3, 41241, -11, -12, -13, -66, -688 }
    };

    /* declaring variables which will hold the length of the arrays left of the targeted element and
       right of the targeted element.
    */
    private static int[] leftArray;
    private static int[] rightArray;

    public static void main(String[] args) {

        System.out.println(Arrays.toString(GetNearby(0, 2, 2)));

    }

    /**
     * This method returns the index of the targeted element
     * 
     * @param twoLevelsArray
     * @param x int to access the first level of the multi array
     * @param y int to access the specific element of the targeted array
     * @return the index of the targeted element
     */
    private static int getTargetedElementIndex(int[][] twoLevelsArray, int x, int y) {

        int countIndex = -1;

        for (int num : twoLevelsArray[x]) {
            countIndex += 1;
            if (num == twoLevelsArray[x][y]) {
                break;
            };
        }

        return countIndex;
    }

    /**
     * <h3>This method returns the length of the array which holds the result elements
     * from the left of the targeted element</h3>
     * 
     * @param array - the array which holds the elements from the left of the targeted element
     * @param countIndex - the index of the targeted element
     * @param range  -  the maximum range for the returned elements (right and left) 
     * @return <code>int</code>:  the length of the leftArray
     */
    private static int getTheLengthOfTheLeftArray(int[] array, int countIndex, int range) {

        if (countIndex > range) {
            leftArray = new int[range];
        } else {
            leftArray = new int[countIndex];
        }

        return leftArray.length;
    }

    /** 
     * <h3>This method returns the length of the targeted array</h3>
     * 
     * @param twoLevelsArray - the data array
     * @param x - the index of the target array
     * @return <code>int</code>:  the length of the targeted array
    */
    private static int getTheLengthOfTheTargetArray(int[][] twoLevelsArray, int x) {

        int targetArrayLength = multi[x].length;

        return targetArrayLength;
    }

    /**
     * <h3>This method returns the length of the array which holds the result elements
     * from the right of the targeted element</h3>
     * 
     * 
     * @param array - the array which holds the elements from the right of the targeted element
     * @param countIndex - the index of the targeted element
     * @param range  -  the maximum range for the returned elements (right and left) 
     * @return <code>int</code>:  the length of the rightArray
     */
    private static int getTheLengthOfTheRightArray(int[] array, int countIndex, int range, int x) {

        int targetArrayLength = getTheLengthOfTheTargetArray(multi, x);

        if (countIndex + 1 == targetArrayLength && countIndex > targetArrayLength - range) {
            rightArray = new int[0];
        } else if (countIndex > targetArrayLength - range) {
            rightArray = new int[targetArrayLength - countIndex];
        } else {
            rightArray = new int[range];
        }

        return rightArray.length;
    }
    
    /**
    * <h3>This method returns the results array with the nearby elements</h3>
    * 
    * <h4>First we get the index of the target element, the length of the leftArray, rightArray
        and resultArray. Then, we add the elements from the left of the targeted element. Here <code>i</code> is the 
        number of the elements which have to be added from left and <code>j</code> is the index of the resultsArray 
        where these elements have to be added. Finally, we add the elements from the right of the targeted
        element. In this case <code>i</code> is the number of the elements which have to be added from right, 
        <code>j</code> is the index of the resultsArray where these elements have to be added. 
        <code>k</code> indicates the index distance from the targeted element for each of the rightArray elements</h4>
    * 
    * @param x - the index of the target array
    * @param y - the index of the targeted element
    * @param range  -  the maximum range for the returned elements (right and left) 
    * @return <code>array</code>:  the array with the nearby elements
    */
    public static int[] GetNearby(int x, int y, int range) {

        // variable which will have as value the index of the targeted element
        int countIndex = getTargetedElementIndex(multi, x, y);

        // setting the length of the array which holds the elements from the left of the targeted element
        int leftArrayLength = getTheLengthOfTheLeftArray(leftArray, countIndex,range);

        // setting the length of the array which holds the elements from the right of the targeted element
        int rightArrayLength = getTheLengthOfTheRightArray(rightArray, countIndex, range, x);

        // setting the length of the array which holds the results elements
        int[] resultArray = new int[leftArrayLength + rightArrayLength];

        // adding to the results array the elements from the leftArray
        for (int i = leftArray.length, j = 0; i > 0; i--, j++) {
            resultArray[j] = multi[x][y - i];
        }

        // adding to the results array the elements from the rightArrray
        for (int i = rightArrayLength, j = resultArray.length - leftArrayLength, k = 1; i > 0; i--, j++, k++) {
            if (leftArray.length > 0) {
                resultArray[j] = multi[x][countIndex + k];
            } else {
                resultArray[0] = multi[x][countIndex + k];
            }
        }

        return resultArray;

    }

}