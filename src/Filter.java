import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;


class Point
{
    private double x;
    private double y;
    private int z;

    public Point(double x, double y, int z)
    {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public int getZ() {
        return z;
    }

    @Override
    public String toString()
    {
        return x + ", " + y + ", " + z;
    }
}

public class Filter
{

    public Filter() throws IOException
    {
        processData();
    }

    private static void readInPoints(List<Point> points) throws IOException
    {
        try (Scanner input = new Scanner(new File("positions.txt")))
        {
            while (input.hasNextLine())
            {
                String[] coords = input.nextLine().split(", ");
                points.add(new Point(
                        Double.parseDouble(coords[0]),
                        Double.parseDouble(coords[1]),
                        Integer.parseInt(coords[2])
                ));
            }
        }
    }

    private static void setOutputFile(String fileName, List<Point> pos) throws IOException {
        new File(fileName);
        List<String> result = new ArrayList<>();
        for (Point p : pos) { result.add(p.toString()); }
        Files.write(Paths.get(fileName), result);
    }

    public static void processData() throws IOException
    {
        List<Point> pos = new ArrayList<>();
        readInPoints(pos);

        List<Point> result = pos.stream()
                .filter(i -> i.getZ() <= 2)
                .map(i -> new Point(i.getX() * 0.5, i.getY() * 0.5, i.getZ()))
                .map(i -> new Point(i.getX() - 150, i.getY() -37, i.getZ()))
                .collect(Collectors.toList());

        setOutputFile("drawMe.txt", result);
    }
}
