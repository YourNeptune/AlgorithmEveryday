// Solution
function sortedSquaredArray(array) {
  return array.map((x) => x * x).sort((a, b) => a - b);
}

exports.sortedSquaredArray = sortedSquaredArray;

// Solution 2
// O(nlogn) time | O(n) space
function sortedSquaredArray(array) {
  const sortedSquares = new Array(array.length).fill(0);
  for (let idx = 0; idx < array.length; idx++) {
    const value = array[idx];
    sortedSquares[idx] = value * value;
  }
  sortedSquares.sort((a, b) => a - b);
  return sortedSquares;
}

exports.sortedSquaredArray = sortedSquaredArray;

// Solution 3
// O(n) time | O(n) space
function sortedSquaredArray(array) {
  const sortedSquares = new Array(array.length).fill(0);
  let smallerValueIdx = 0;
  let largerValueIdx = array.length - 1;

  for (let idx = array.length - 1; idx >= 0; idx--) {
    const smallerValue = array[smallerValueIdx];
    const largerValue = array[largerValueIdx];

    if (Math.abs(smallerValue) > Math.abs(largerValue)) {
      sortedSquares[idx] = smallerValue * smallerValue;
      smallerValueIdx++;
    } else {
      sortedSquares[idx] = largerValue * largerValue;
      largerValueIdx--;
    }
  }
  return sortedSquares;
}

exports.sortedSquaredArray = sortedSquaredArray;
