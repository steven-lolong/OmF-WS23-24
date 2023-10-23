function addB(fa, a, b) {
  return fa(a, b);
}

console.log(
  (a, b) => {
    a + b;
  },
  2,
  3
);

console.log(
  addB(
    (a, b) => {
      return a + b;
    },
    2,
    3
  )
);
