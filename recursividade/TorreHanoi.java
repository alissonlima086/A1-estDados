package recursividade;

public class TorreHanoi {
    public static void torreDeHanoi(int numDiscos, String origem, String destino, String ref){
        if(numDiscos == 1){
            // Move direto para o destino
            System.out.println("Disco 1 de "+ origem+" para "+ destino);
        } else {

            torreDeHanoi(numDiscos- 1, origem, ref, destino);
            System.out.println("Mover disco "+ numDiscos+" de "+origem+" para "+destino);
            torreDeHanoi(numDiscos- 1, ref, destino, origem);
        }
    }

    public static void main(String[] args) {
        int numDiscos = 1;
        torreDeHanoi(numDiscos, "A", "B", "C");
    }
}
