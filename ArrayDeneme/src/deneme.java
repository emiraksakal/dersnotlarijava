import java.util.Scanner;

public class deneme {

    public static void main(String[] args) {

        int array[] = new int[5];
        Scanner input = new Scanner(System.in);

        for (int i=0;i<5;i++) {
            System.out.println("sayı gir");
            array[i]=input.nextInt();

        }

        for (int j=0;j<5;j++) {
            System.out.println(array[j] + " "+ (j+1) +".sayı ");  
        }

    }
}
