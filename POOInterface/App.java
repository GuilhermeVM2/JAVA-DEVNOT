package POOInterface;

public class App {
    public static void main(String[] args) {
        Quadrado Figura1 = new Quadrado(6);
        System.out.println("Area= "+Figura1.getArea()+" Perimetro="+Figura1.getPerimetro()+Figura1.getNomeFigura());

        Retangulo Figura2 = new Retangulo(10, 15);
        System.out.println("Area= "+Figura2.getArea()+" Perimetro="+Figura2.getPerimetro()+Figura2.getNomeFigura());;

        Trapezio figura3 = new Trapezio(0, 0, 0)

    }
}
