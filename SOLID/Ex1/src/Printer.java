import java.util.*;

public class Printer {
    public void printIn(String raw)
    {
        System.out.println("INPUT: " + raw);
    }
    public void printError(List<String> errors)
    {
        System.out.println("ERROR: cannot register");
        for (String e : errors) System.out.println("- " + e);
    }
    public void printOut(StudentRecord rec, int cnt)
    {
        System.out.println("OK: created student " + rec.id);
        System.out.println("Saved. Total students: " + cnt);
        System.out.println("CONFIRMATION:");
        System.out.println(rec);
    }
}
