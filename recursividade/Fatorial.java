package recursividade;

public class Fatorial {

    public static int calculaFatorial(int num){
        if(num == 0){
            return 1;
        } else {
            if(num >= 1){
                System.out.print(num);
                if(num - 1 == 0){
                    System.out.print("=");
                }else {
                    System.out.print("+");
                }
            }
            return num * calculaFatorial(num -1);
        }
    }

    public static void main(String[] args) {
        System.out.println(calculaFatorial(5));
    }
}
