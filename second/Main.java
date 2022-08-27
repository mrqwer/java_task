class Main{
    public static void main(String[] args){
        Solution2 s = new Solution2();
        int [] arr = new int[]{5,6,3,2,5,1,4,9};
        s.sortArr(arr);
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
