//Packages
package edu.norcocollege.cis18b.week2.alerts;

/**
 * TODO:
 *  - Convert this class into a Java 17+ record
 *  - Include the following fields:
 *      String id
 *      String sourceSystem
 *      String severity
 *      String description
 *      long timestamp
 *
 *  - (Optional stretch) Add validation in a compact constructor
 */
//Begins Here
public record SecurityAlert(String id, String sourceSystem, String severity, String description, long timestamp) {
    // Compact constructor for validation
    public SecurityAlert{
        // Basic validation example
        if(id == null || id.isBlank()){
            throw new IllegalArgumentException("ID must not be blank");
        }
        if(sourceSystem == null || sourceSystem.isBlank()){
            throw new IllegalArgumentException("Source System must not be blank");
        }
        if(severity == null || severity.isBlank()){
            throw new IllegalArgumentException("Severity must not be blank");
        }
        if(description == null || description.isBlank()){
            throw new IllegalArgumentException("Description must not be blank");
        }
        if(timestamp <= 0){
            throw new IllegalArgumentException("Timestamp must be a positive value");
        }
    }
}

