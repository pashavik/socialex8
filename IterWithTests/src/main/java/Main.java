public class Main {
    public static void main(String[] args) {
        Iter<String> arr=new Iter<String>(10);
        for(int i=0; i<10; i++){
            arr.put(i, "String"+i);
        }
        for (String s:arr){
            System.out.println(s);
        }
    }
}
