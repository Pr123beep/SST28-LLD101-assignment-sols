import java.nio.charset.StandardCharsets;

public class CsvExporter extends Exporter {
    @Override
    public ExportResult doExport(ExportRequest req) {

        String body = escape(req.body);
        String csv = "title,body\n" + req.title + "," + body + "\n";
        
        return new ExportResult("text/csv", csv.getBytes(StandardCharsets.UTF_8));
    }
    private String escape(String s) {
        
        if(s.contains(",") || s.contains("\n") || s.contains("\"")) return "\"" + s.replace("\"", "\"\"") + "\"";

        return s;
    }
}
