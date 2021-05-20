// Solution
function sortedSquaredArray(array) {
  return array.map((x) => x * x).sort((a, b) => a - b);
}

exports.sortedSquaredArray = sortedSquaredArray;