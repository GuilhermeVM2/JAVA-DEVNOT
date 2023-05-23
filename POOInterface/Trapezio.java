package POOInterface;

public class Trapezio implements FiguraGeometriva{
    int baseMaior;
    int baseMenor;
    int altura;
    int lado3;
    int lado2;
    
    public Trapezio(int lado1, int lado2) {
        this.lado1 = lado1;
        this.lado2 = lado2;
    }

    public int getLado1() {
        return lado1;
    }
    public void setLado1(int lado1) {
        this.lado1 = lado1;
    }
    public int getLado2() {
        return lado2;
    }
    public void setLado2(int lado2) {
        this.lado2 = lado2;
    }
    public int getBaseMaior() {
        return baseMaior;
    }
    public void setBaseMaior(int baseMaior) {
        this.baseMaior = baseMaior;
    }
    public int getBaseMenor() {
        return baseMenor;
    }
    public void setBaseMenor(int baseMenor) {
        this.baseMenor = baseMenor;
    }
    public int getAltura() {
        return altura;
    }
    public void setAltura(int altura) {
        this.altura = altura;
    }
    @Override
    public double getArea() {
        int area = (baseMaior+baseMenor*altura)/2;
        return area;
    }
    @Override
    public String getNomeFigura() {
        // TODO Auto-generated method stub
        return "Trapezio";
    }
    @Override
    public double getPerimetro() {
        int perimetro = baseMaior+baseMenor+lado1+lado2;
        return perimetro;
    }
    public Trapezio(int baseMaior, int baseMenor, int altura) {
        this.baseMaior = baseMaior;
        this.baseMenor = baseMenor;
        this.altura = altura;
    }

    
}
