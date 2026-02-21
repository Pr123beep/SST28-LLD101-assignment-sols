import java.util.*;

public class OnboardingService {

    private final Saving db;
    private final Parser parser = new Parser();
    private final Validator validator = new Validator();
    private final Printer printer = new Printer();


    public OnboardingService(Saving db) { this.db = db; }

    public void registerFromRawInput(String raw) {
        printer.printIn(raw);

        Map<String, String> mp = parser.parse(raw);
        List<String> errors = validator.validate(mp);

        if(!errors.isEmpty())
        {
            printer.printError(errors);
            return;
        }
        String id = IdUtil.nextStudentId(db.count());
        StudentRecord rec = new StudentRecord(id, mp.get("name"), mp.get("email"), mp.get("phone"), mp.get("program"));
        
        db.save(rec);
        printer.printOut(rec, db.count());

    }
}
