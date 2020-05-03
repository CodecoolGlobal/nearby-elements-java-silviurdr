import java.util.ArrayList;
import java.util.Arrays;

public class NearbyElementsBetter {


    private static int[][] multi = new int[][] {

        { 2, 0, 4, 1241, 12, 5, 11, 1110, -42, 424, 1, 12323 },
            { 1, 3, 5, 7 },
            { 321, 320, 32, 3, 41241, -11, -12, -13, -66, -688 }
    };

    private static ArrayList<Integer> resultsArray = new ArrayList<Integer>();

    public static void main(String[] args) {

        System.out.println(Arrays.toString(getNearbyElements(0, 2, 2)));
    }


    private static int[] getNearbyElements(int x, int y, int range) {

        int targetedArrayLength = multi[x].length;

        if (y - range > 0) {
            for (int i = range; i > 0; i--) {
                resultsArray.add(multi[x][y - i]);
            }
        } else if (y - range <= 0) {
            for (int i = y; i > 0; i--) {
                resultsArray.add(multi[x][y - i]);
            }
        }

        if (targetedArrayLength - y > range) {
            for (int i = 1; i <= range; i++) {
                resultsArray.add(multi[x][y + i]);
            }
        } else if (targetedArrayLength - y <= range && y + 1 < targetedArrayLength) {
            for (int i = 1, j = y; i <= range || j < targetedArrayLength; i++, j++) {
                resultsArray.add(multi[x][y + i]);
            }
        }

        // for (int j = y - range; j <= y + range; j++) {
        //     System.out.println(j);
        //     if (j >= 0 && j < multi[x].length && y != j) {
        //         resultsArray.add(multi[x][j]);
        //     }
        // }

        int[] finalResults = new int[resultsArray.size()];

        for (int i = 0; i < resultsArray.size(); i++) {
            finalResults[i] = resultsArray.get(i);
        }

        return finalResults;
    }
}