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
//     public static void printTwoDArr(int [][] arr){
//         for(int i = 0; i < arr.length; i++){
//             for(int j = 0; j < arr[i].length; j++){
//                 System.out.print(arr[i][j] + " ");
//             }
//             System.out.println();
//         }
//     }
//     public static int getMax(int [][] arr){
//         int max = arr[0][0];
//         for(int i = 0; i < arr.length; i++){
//             for(int j = 0; j < arr[i].length; j++){
//                 if(max < arr[i][j]){
//                     max = arr[i][j];
//                 }
//             }
//         }
//         return max;
//     }
//     public static int getMin(int[][] arr){
//         int min = arr[0][0];
//         for(int i = 0; i < arr.length; i++){
//             for(int j = 0; j < arr[i].length; j++){
//                 if(min > arr[i][j]){
//                     min = arr[i][j];
//                 }
//             }
//         }
//         return min;
//     }
//     public static double getAverage(int[][] arr){
//         int sum = 0;
//         int cnt = 0;
//         for(int i = 0; i < arr.length; i++){
//             for(int j = 0; j < arr[i].length; j++){
//                 sum+=arr[i][j];
//                 cnt +=1;
//             }
//         }
//         return (double)sum/cnt;
//     }
}
