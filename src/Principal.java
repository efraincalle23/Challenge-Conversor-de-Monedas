import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        String claveApi = "Tu clave api qui";
        ConvertirMoneda convertirMoneda = new ConvertirMoneda("f49b0512fb81652985d50e6f");
        Menu menu = new Menu();
        Scanner lectura = new Scanner(System.in);

        while (true){
            menu.opciones();
            String opcion = menu.obtenerOpcion(lectura);
            if (opcion.equals("7")) {
                System.out.println("Gracias por usar el conversor. ¡Hasta luego!");
                break;
            }
            String desde ="";
            String hacia ="";

            switch (opcion){
                case "1":
                    desde = "USD";
                    hacia = "ARS";
                    break;
                case "2":
                    desde = "ARS";
                    hacia = "USD";
                    break;
                case "3":
                    desde = "USD";
                    hacia = "BRL";
                    break;
                case "4":
                    desde = "BRL";
                    hacia = "USD";
                    break;
                case "5":
                    desde = "USD";
                    hacia = "COP";
                    break;
                case "6":
                    desde = "COP";
                    hacia = "USD";
                    break;
                default:
                    System.out.println("Opción inválida.");
                    continue;
            }

            try {
                System.out.println("****************************************");
                System.out.print("Ingrese el valor que deseas convertir:\n");
                double monto = lectura.nextDouble();
                double resultado = convertirMoneda.convertir(desde, hacia, monto);

                System.out.printf("El valor %.2f [%s] corresponde al valor final de >>> %.2f [%s]%n",
                        monto, desde, resultado, hacia);

                lectura.nextLine();
            }catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                lectura.nextLine();
            }
        }
        lectura.close();
    }
}
