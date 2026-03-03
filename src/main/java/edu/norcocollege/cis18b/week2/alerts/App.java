//Packages
package edu.norcocollege.cis18b.week2.alerts;
//Imports
import java.util.List;
import edu.norcocollege.cis18b.week2.alerts.SecurityAlert;
import edu.norcocollege.cis18b.week2.alerts.SecurityAlertManager;

/**
 * Entry point for Week 1.
 *
 * TODO:
 *  - Create at least 3 SecurityAlert objects
 *  - Add them to SecurityAlertManager
 *  - Print a formatted report using a text block
 *  - Demonstrate calling at least one manager method
 */
//Begins Here
public class App {
    // Main method
    public static void main(String[] args) {

        // TODO: Create SecurityAlertManager instance
        SecurityAlertManager manager = new SecurityAlertManager();
        // TODO: Create multiple SecurityAlert records
        var alert1 = new SecurityAlert("1", "Firewall", "High", "Unauthorized access attempt detected", System.currentTimeMillis());
        var alert2 = new SecurityAlert("2", "Intrusion Detection System", "Medium", "Suspicious network activity observed", System.currentTimeMillis());
        var alert3 = new SecurityAlert("3", "Antivirus", "Low", "Malware signature detected on endpoint", System.currentTimeMillis());
        var alert4 = new SecurityAlert("4", "Authentication System", "Critical", "A Brute Force Attack Detected", System.currentTimeMillis());
        // TODO: Add alerts to manager
        manager.addAlert(alert1);
        manager.addAlert(alert2);
        manager.addAlert(alert3);
        manager.addAlert(alert4);
        //Query by severity and print results
        List<SecurityAlert> highAlerts = manager.findBySeverity("High");
        System.out.println("High Severity Alerts:"+ highAlerts.size());
        for(SecurityAlert alert: highAlerts){
            System.out.println("- "+ alert.id()+ ": "+ alert.sourceSystem()+ " - "+ alert.description());
        }
        



        // TODO: Print formatted report using text block
        /*
        System.out.println("""
            === SECURITY ALERT REPORT ===
            Total Alerts: %d
            High Severity Alerts: %d
            """.formatted(total, highCount));
        */
    }
}