public class greatersmallarray {
    public static void main(String[] args){
    int arr[]={5,2,9,4,7,6,8};

    int small=arr[0];
    int great=arr[0];

    for (int i=1;i<arr.length;i++){
        if(arr[i]<small){
            small=arr[i];
        }
        if(arr[i]>great){
            great=arr[i];
        }
    }
    System.out.println("Smallest: "+small);
    System.out.println("Greatest: "+ great);
}
}
