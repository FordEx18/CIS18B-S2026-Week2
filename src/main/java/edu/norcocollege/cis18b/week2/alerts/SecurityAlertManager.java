//Packages
package edu.norcocollege.cis18b.week2.alerts;
//Imports
import java.util.List;
import java.util.Optional;
import java.util.ArrayList;

/**
 * TODO:
 *  - Store alerts in an internal List
 *  - Implement all required methods
 *  - Use Streams where appropriate
 *  - Use Optional instead of returning null
 *  - Use a modern switch expression
 */
public class SecurityAlertManager {

    // TODO: Declare a private List<SecurityAlert> to store alerts
    private List<SecurityAlert> alerts = new ArrayList<>();

    /**
     * TODO:
     *  - Reject null
     *  - Add alert to internal list
     */
    public void addAlert(SecurityAlert alert) {
        // Validate input
        if (alert == null) {
            throw new IllegalArgumentException("Alert cannot be null");
        }
        alerts.add(alert);
    }

    /**
     * TODO:
     *  - Return Optional.empty() if id is null
     *  - Use streams to find first match
     */
    public Optional<SecurityAlert> findById(String id) {
        // Return empty if id is null
        if (id == null) {
            return Optional.empty();
        }
        return alerts.stream()
                .filter(alert -> alert.id().equals(id))
                .findFirst();
    }

    /**
     * TODO:
     *  - Return empty list if severity is null
     *  - Use streams to filter by severity
     */
    public List<SecurityAlert> findBySeverity(String severity) {
        // Return empty list if severity is null
        if(severity==null){
            return List.of();
        }
        return alerts.stream()
                .filter(alert-> alert.severity().equalsIgnoreCase(severity))
                .toList();
    }

    /**
     * TODO:
     *  - Remove alert by ID
     *  - Return true if removed, false otherwise
     */
    public boolean removeAlert(String id) {
        // Return false if id is null
        if(id==null){
            return false;
        }
        return alerts.removeIf(alert -> alert.id().equals(id));
    }

    /**
     * TODO:
     *  - Reject null alert
     *  - Use pattern matching with instanceof
     *  - Use modern switch expression
     *  - Throw IllegalArgumentException for unknown severity
     */
    public String getSeverityRecommendation(SecurityAlert alert) {
        // Validate input
        if(alert==null){
            throw new IllegalArgumentException("Alert cannot be null");
        }
        //Pattern matching with instanceof
        if (alert instanceof SecurityAlert sa) {
            // Modern switch expression
            return switch (sa.severity().toLowerCase()) {
                case "low" -> "Log and monitor.";
                case "medium" -> "Investigate within 24 hours.";
                case "high" -> "Escalate to engineering.";
                case "critical" -> "Immediate incident response required.";
                default -> throw new IllegalArgumentException("Unknown severity: " + sa.severity());
            };
        }
        // This point should never be reached since alert is non-null SecurityAlert
        throw new IllegalStateException("Unexpected alert type");
    }
}