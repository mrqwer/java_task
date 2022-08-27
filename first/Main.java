// package javacourse.first;

class Main{
    public static void main(String[] args){
        int [][] arr = new int[5][5];
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){
                arr[i][j] = (int)(Math.random()*10);
            }
        }
        Solution1 s = new Solution1();
        s.printTwoDArr(arr);
        System.out.println("Max element is: " + s.getMax(arr));
        System.out.println("Min elemen is: " + s.getMin(arr));
        System.out.println("Average element is: " + s.getAverage(arr));
    }
}
