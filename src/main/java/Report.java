import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Daan on 2-7-2015.
 */
public class Report {

    private final String reported;
    private final String reporter;
    private final String details;
    private final String date;
    private Date rdate;
    private ArrayList<Report> reports = new ArrayList<Report>();

    public Report(String reported, String reporter, String details, Date date) {
        this.reported = reported;
        this.reporter = reporter;
        this.details = details;
        SimpleDateFormat f = new SimpleDateFormat("yyyy/MM/dd");
        this.date = f.format(date);
        this.rdate = date;
    }

    public ArrayList<Report> getReporters(String reporter) {
        ArrayList<Report> reports = new ArrayList<>();
        for(Report r : reports) {
            reports.add(r);
        }
        return reports;
    }

    public ArrayList<Report> getReporteds(String reported) {
        ArrayList<Report> reports = new ArrayList<>();
        for(Report r : reports) {
            reports.add(r);
        }
        return reports;
    }

    public Report getReport(String reporter, String reported) {
        for(Report report : getReports()) {
            if(report.getReporter().equals(reporter) && report.getReported().equals(reported)) return report;
        }
        return null;
    }

    public String getReported() {
        return reported;
    }

    public String getDetails() {
        return details;
    }

    public String getReporter() {
        return reporter;
    }

    public String getDate() {
        return date;
    }

    public Date getRdate() {
        return rdate;
    }

    public void setRdate(Date rdate) {
        this.rdate = rdate;
    }

    public ArrayList<Report> getReports() {
        return reports;
    }

    public void setReports(ArrayList<Report> reports) {
        this.reports = reports;
    }

    public void loadReports() {

    }
}
