package Two_Number_Sum;

import java.util.Arrays;
import java.util.HashMap;
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

    // Solution 2: HashSet
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

    //Solution 4: if we have to return the index rather than the number itself, use HashMap
    // O(n) time & space
    public static int[] solution4(int[] array, int target) {
        HashMap<Integer,Integer> myMap = new HashMap<>();
        for(int i = 0; i < array.length; i++){
            int potentialMatch = target - array[i];
            if(myMap.containsKey(potentialMatch)){
                return new int[]{myMap.get(potentialMatch), i}; // return their index
            }else{
                myMap.put(array[i],i);
            }
        }
        return null;
    }

}