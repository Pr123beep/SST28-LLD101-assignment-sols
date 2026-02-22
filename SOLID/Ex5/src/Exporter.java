public abstract class Exporter {
    // implied "contract" but not enforced (smell)
    public final ExportResult export(ExportRequest req)
    {
        if(req == null) throw new IllegalArgumentException("Request cannot be null");

        String title, body;

        if(req.title == null) title = "";
        else title = req.title;

        if(req.body == null) body = "";
        else body = req.body;
        
        return doExport(new ExportRequest(title, body));
    }
    protected abstract ExportResult doExport(ExportRequest req);
}
