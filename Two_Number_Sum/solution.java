package Two_Number_Sum;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Program{
    // Solution 1
    // O(n^2) time | O(1) space
    public static int[] solution1(int[] array, int targetSum) {
        for(int i = 0; i < array.length-1; i++){
            int firstNum = array[i];
            for(int j = i+1; j < array.length; j++){
                int secondNum = array[j];
                if(firstNum + secondNum == targetSum){
                    // we find the value
                    return new int[]{firstNum, secondNum};
                }
            }
        }
        return new int[0];
    }

    // Solution 2
    // O(n) time | O(n) space
    public static int[] solution2(int[] array, int targetSum) {
        Set<Integer> nums = new HashSet<>();
        for(int num : array){
            int potentialMatch = targetSum - num;
            if(nums.contains(potentialMatch)){
                // we find the value
                return new int[]{num, potentialMatch};
            }else{
                nums.add(num);
            }
        }
        return new int[0];
    }

    // Solution 3
    // O(nlog(n)) time | O(1) space
    public static int[] solution3(int[] array, int targetSum) {
        Arrays.sort(array);
        int leftInx = 0;
        int rightInx = array.length - 1;
        while(leftInx < rightInx){
            if(array[leftInx] + array[rightInx] == targetSum){
                // we find the value
                return new int[]{array[leftInx], array[rightInx]};

            }else if(array[leftInx] + array[rightInx] < targetSum){
                leftInx++;
            }else{
                rightInx--;
            }
        }
        return new int[0];
    }
}