// Define the abstract Shape class
abstract class Shape {
    // Abstract method to calculate area
    abstract double calculateArea();
}

// Circle class inheriting from Shape
class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    double calculateArea() {
        return Math.PI * radius * radius;
    }
}

// Rectangle class inheriting from Shape
class Rectangle extends Shape {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    double calculateArea() {
        return width * height;
    }
}

// Triangle class inheriting from Shape
class Triangle extends Shape {
    private double base;
    private double height;

    public Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    @Override
    double calculateArea() {
        return 0.5 * base * height;
    }
}

// Main class to demonstrate polymorphism
public class ShapeCalculator {
    public static void main(String[] args) {
        // Create an array of Shape objects
        Shape[] shapes = new Shape[3];

        // Instantiate the shapes
        shapes[0] = new Circle(5);
        shapes[1] = new Rectangle(4, 6);
        shapes[2] = new Triangle(3, 8);

        // Calculate and print the area of each shape
        for (Shape shape : shapes) {
            System.out.println("The area of the shape is: " + shape.calculateArea());
        }
    }
}
