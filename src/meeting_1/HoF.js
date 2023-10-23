let aPb = (a, b) => {
  a = 7;
  b = 8;
  return a + b;
};

let aPb_1 = function (a, b) {
  a = 7;
  b = 8;
  return a + b;
};

let t_1 = aPb;
let t_2 = aPb(3, 4);

console.log(t_);
