package recursividade;

public class ContagemRegressiva {

    public static void contagemRegressiva(int num) throws  InterruptedException{
        if(num == 0) {
            System.out.println("FIM!!!");
        } else{
            System.out.println(num);;
            Thread.sleep(1000);
            contagemRegressiva(num -1);
        }
    }

    public static void main(String[] args) throws InterruptedException{
        contagemRegressiva(10);
    }

}
