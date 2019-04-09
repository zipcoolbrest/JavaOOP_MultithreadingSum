public class Main {
    public static  void main(String [] args){

        //one Thread
       int [] bigArray = new int[200000000];
        for (int i = 0; i < bigArray.length ; i++) {
            bigArray[i] = (int)(Math.random()*10);
        }
        System.out.println("bigArray READY!!");
        double a = 0;
        double b = 0;
        long startTime = System.currentTimeMillis();
        int sum = 0;
        for (int i : bigArray) {
            sum += i;
        }
        System.out.println("Linear sum = " + sum + "   time:" + (a = System.currentTimeMillis() - startTime));

        //four Thread

        MultithreadingSummer ms = new MultithreadingSummer(bigArray,  4);

        startTime = System.currentTimeMillis();
        System.out.println("Multithreading sum = " + ms.getResult() + "   time:" + (b = System.currentTimeMillis() - startTime));
        System.out.println("ratio: " + a/b);


    }
}
