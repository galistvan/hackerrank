package hu.gistv.hackerrank.solutions.new_year_chaos;

//https://www.hackerrank.com/challenges/new-year-chaos/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=arrays

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import java.util.Scanner;
import org.junit.Test;

public class Solution {

    private static final Scanner scanner = new Scanner(System.in);

    // Complete the minimumBribes function below.
    static void minimumBribes(int[] q) {
        int bribes = minimumBribes2(q);
        if (bribes < 0) {
            System.out.println("Too chaotic");
        } else {
            System.out.println(bribes);
        }
    }

    private static int minimumBribes2(int[] q) {
        int bribes = 0;
        int diff;
        for (int i = q.length -1 ; i >= 0; i--) {
            diff = q[i] - (i + 1);
            if (diff > 2) {
                return -1;
            }
            for (int j = Math.max(0, q[i]-2); j < i; j++) {
                if (q[j] > q[i]) {
                    bribes++;
                }
            }
        }
        return bribes;
    }

    public static void main(String[] args) {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] q = new int[n];

            String[] qItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int qItem = Integer.parseInt(qItems[i]);
                q[i] = qItem;
            }

            minimumBribes(q);
        }

        scanner.close();
    }

    @Test
    public void test() {
        //1  2  3  4  5
        int[] input = new int[]{2, 1, 5, 3, 4};
        int bribes = Solution.minimumBribes2(input);
        assertThat(bribes, is(3));
    }

    @Test
    public void test2() {
        //1  2  3  4  5
        int[] input = new int[]{2, 5, 1, 3, 4};
        int bribes = Solution.minimumBribes2(input);
        assertThat(bribes, is(-1));
    }


    @Test
    public void test3() {
        //1  2  3  4  5
        int[] input = new int[]{1, 2, 5, 3, 4, 7, 8, 6};
        int bribes = Solution.minimumBribes2(input);
        assertThat(bribes, is(4));
    }

    @Test
    public void test4() {
        //1  2  3  4  5
        int[] input = new int[]{5, 1, 2, 3, 7, 8, 6, 4};
        int bribes = Solution.minimumBribes2(input);
        assertThat(bribes, is(-1));
    }

    @Test
    public void test5() {
        //1  2  3  4  5
        int[] input = new int[]{1, 2, 5, 3, 7, 8, 6, 4};
        int bribes = Solution.minimumBribes2(input);
        assertThat(bribes, is(7));
    }

    @Test
    public void test6() {
        //1  2  3  4  5
        int[] input = new int[]{2, 1, 5, 3, 4};
        int bribes = Solution.minimumBribes2(input);
        assertThat(bribes, is(3));
    }

    @Test
    public void test7() {
        //1  2  3  4  5
        int[] input = new int[]{2, 5, 1, 3, 4};
        int bribes = Solution.minimumBribes2(input);
        assertThat(bribes, is(-1));
    }
}
