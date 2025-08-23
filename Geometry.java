public class Geometry {
    
    public static void calculateArea(double radius) {
        double area = 4 * radius * radius * Math.PI;
        String areaFormatted = String.format("%.2f", area); 
        System.out.println("The area of a sphere with a radius of " + radius + " is " + areaFormatted);
    }

    public static void calculateArea(double radius, double height) {
        double area = (2 * radius * radius * Math.PI) + (2 * Math.PI * radius * height);
        String areaFormatted = String.format("%.2f", area); 
        System.out.println("The area of a cylinder with a radius of " + radius + " and a height of " + height + " is " + areaFormatted);
    }

    public static void calculateArea(boolean cone, double radius, double height) {
        double area = Math.PI * radius * (radius + Math.sqrt(height * height + radius * radius));
        String areaFormatted = String.format("%.2f", area); 
        System.out.println("The area of a cone with a radius of " + radius + " and a height of " + height + " is " + areaFormatted);
    }

    public static void calculateVolume(double radius) {
        double volume = (4 * Math.PI * radius * radius * radius) / 3;
        String volumeFormatted = String.format("%.2f", volume);
        System.out.println("the volume of a sphere with a radius of " + radius + " is " + volumeFormatted);
    }

    public static void calculateVolume(double radius, double height) {
        double volume = Math.PI * radius * radius * height;
        String volumeFormatted = String.format("%.2f", volume);
        System.out.println("the volume of a cylinder with a radius of " + radius + " and a height of " + height + " is " + volumeFormatted);
    }

    public static void calculateVolume(boolean cone, double radius, double height) {
        double volume = Math.PI * radius * radius * height / 3;
        String volumeFormatted = String.format("%.2f", volume);
        System.out.println("the volume of a cone with a radius of " + radius + " and a height of " + height + " is " + volumeFormatted);
    }

}