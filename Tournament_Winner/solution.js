// Solution 1
function tournamentWinner(competitions, results) {
  let output = {};
  competitions.forEach((competition) => {
    let index = competitions.index(competition); // 0, 1, 2 ...
    if (results[index] === 1) {
      output[competition[0]] = isNaN(output[competition[0]])
        ? 3
        : output[competition[0]] + 3;
    } else if (results[index] === 0) {
      output[competition[1]] = isNaN(output[competition[1]])
        ? 3
        : output[competition[1]] + 3;
    }
  });

  const maxValue = Object.values(output).sort((a, b) => b - a)[0];
  const winner = Object.keys(output).find((key) => output[key] === maxValue);

  return winner;
}
exports.tournamentWinner = tournamentWinner;


// Solution 2
function tournamentWinner(competitions, results) {
  let output = {};
  competitions.forEach((competition) => {
    const index = competitions.index(competition); // 0, 1, 2 ...
    const winnerIndex = competition[index] === 1 ? 0 : 1
    const winner = competition[winnerIndex]
    output[winner] = isNaN(output[winner])
      ? 3
      : output[winner] + 3;
  });

  const maxValue = Object.values(output).sort((a, b) => b - a)[0];
  const finalWinner = Object.keys(output).find((key) => output[key] === maxValue);

  return finalWinner;
}
exports.tournamentWinner = tournamentWinner;
