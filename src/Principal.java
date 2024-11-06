import java.io.IOException;

public static void main() throws IOException, InterruptedException {
        System.out.println("*************************************");
    System.out.println("Bem-vindo ao sistema de conversão de moedas OnTime");
    System.out.println("Seguem as divisas de moeda e os números que são respectivos a eles");
    System.out.println("Tenha-os como referência para os próximos passos\n");

    System.out.println("""
            1- Real brasileiro (Brasil)
            2- Peso argentino (Argentina)
            3- Dólar americano (Estados Unidos)
            4- Dólar jamaicano (Jamaica)
            5- Dólar canadense (Canadá)
            6- Rubro russo (Russia)""");
    System.out.println("*******************************************");
    new ApiConversor();


}

