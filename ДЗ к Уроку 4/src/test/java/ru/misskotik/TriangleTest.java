package ru.misskotik;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static java.lang.Double.NaN;
import static org.junit.jupiter.api.Assertions.*;

public class TriangleTest  {
    static Logger logger = LoggerFactory.getLogger(TriangleTest.class);

    Integer a;
    Integer b;
    Integer c;
    Boolean myBoolean = true;


    @DisplayName("Check Triangle")
    @Test
    void testTriangleExists() throws NotATriangleException {
        logger.info("Checking if Triangle exists");
        a = 3;
        b = 4;
        c = 5;
        double sTriangle = Triangle.getTriangleSquare(a, b, c);
        assertTrue(sTriangle >= 0, "Not a Triangle");

    }

    @DisplayName("This is not Triangle")
    @Test
    void testThisIsNotTriangle() throws NotATriangleException {
        logger.info("Wrong parameters test");
        a = 3;
        b = 4;
        c = 90;
        double sTriangle = Triangle.getTriangleSquare(a, b, c);

//        sTriangle = Triangle.getTriangleSquare(a, b, c);


        assertFalse (sTriangle >=0, "This is Triangle");
    }

    @DisplayName("Triangle doesn't exist")
    @Test
    void testTriangleDoesNotExist() throws NotATriangleException {
        logger.info("Checking wrong parameters - one of the size is 0");
        a = 0;
        b = 0;
        c = 0;
        double sTriangle = Triangle.getTriangleSquare(a, b, c);


//        sTriangle = Triangle.getTriangleSquare(a, b, c);

        assertFalse(sTriangle >=0, "Test failed");

    }

    @DisplayName("Triangle Square")
    @Test
    void testTriangleSquare() throws NotATriangleException {
        logger.info("Checking if Square is right");
        a = 3;
        b = 4;
        c = 5;
        double sTriangle = Triangle.getTriangleSquare(a, b, c);
        ;

        sTriangle = Triangle.getTriangleSquare(a, b, c);

//        assertTrue(sTriangle ==6, "Wrong Square");
        Assertions.assertEquals(6, sTriangle);

    }

//    @DisplayName("Throw Exception")
//    @Test
//    void testThrowException() {
//        logger.info("Checking Exception");
//        Triangle triangle = new Triangle ();
//        Assertions.assertThrows(NotATriangleException.class, () -> triangle.getTriangleSquare (0,4,5), "No Exception");


//    }



}