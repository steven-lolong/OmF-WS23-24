let a = 1;
startPost: while (true) {
  console.log(a);
  a++;

  if (a < 10) continue startPost;

  break;
}
