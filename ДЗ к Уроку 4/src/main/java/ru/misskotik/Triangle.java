package ru.misskotik;

/**
 * Hello world!
 *
 */
public class Triangle {
    public static void main(String[] args) throws NotATriangleException {

        getTriangleSquare(3, 4, 5);
        System.out.println(getTriangleSquare(3, 4, 0));
    }

    public static double getTriangleSquare(int a, int b, int c) throws NotATriangleException {
//        if (a == 0 || b == 0 || c == 0 || a + b < c || b + c < a || a + c < b)
//            throw new NotATriangleException();

            double p = (a + b + c) / 2.0;

            if (a == 0 && b == 0 && c == 0) {
                System.out.println("This is Not a Triangle");
                return -1;
            } else if (a + b < c && b + c < a && a + c < b) {
                System.out.println("Wrong parameters");
                return -1;

            }

        {
            double s = Math.sqrt(p * (p - a) * (p - b) * (p - c));

            System.out.println("Triangle Square " + s);

            return s;
        }

    }
}


















