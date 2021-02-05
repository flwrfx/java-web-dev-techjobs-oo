package org.launchcode.techjobs_oo.Tests;

import org.junit.Before;
import org.junit.Test;
import org.launchcode.techjobs_oo.*;

import static org.junit.Assert.*;

public class JobTest {
    Job testJob1;
    Job testJob2;
    Job constructorJob;
    Job equalityJob1;
    Job equalityJob2;
    Job toStringJob;

    @Before
    public void createJobObjects(){
        testJob1 = new Job();
        testJob2 = new Job();
        //TODO: there's probably a better way to do this?
        constructorJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        equalityJob1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        equalityJob2 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        toStringJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
    }

    @Test
    /**
     * (Empty) Constructor Sets ID test
     * */
    public void testSettingJobId() {
        assertFalse(testJob1.getId() == testJob2.getId());//checks that the two separate job objects have two separate IDs
        assertTrue(testJob2.getId() - testJob1.getId() == 1);//checks to see that the two job objects' ID's values differ by one
    }

    @Test
    /**
     * Constructor Sets All Fields test
     * */
    public void testJobConstructorSetsAllFields(){

        //name
        assertEquals(constructorJob.getName(), "Product tester");
        //employer
        assertEquals(constructorJob.getEmployer().getValue(), "ACME");
        assertTrue(constructorJob.getEmployer() instanceof Employer);
        //location
        assertEquals(constructorJob.getLocation().getValue(), "Desert");
        assertTrue(constructorJob.getLocation() instanceof Location);
        //positiontype
        assertEquals(constructorJob.getPositionType().getValue(), "Quality control");
        assertTrue(constructorJob.getPositionType() instanceof PositionType);
        //corecompetency
        assertEquals(constructorJob.getCoreCompetency().getValue(), "Persistence");
        assertTrue(constructorJob.getCoreCompetency() instanceof CoreCompetency);
    }

    @Test
    /**
     * Equality test
     * */
    public void testJobsForEquality(){//clean up jobject creation in @Before? keep separate IDs intact
        assertFalse(equalityJob1.equals(equalityJob2));
    }

    @Test
    /**
     * TDD-style setup to test/develop toString()
     * */
    public void testToStringStartsAndEndsWithBlankLine(){
        assertTrue(testJob1.toString().startsWith("\n"));//?
        assertTrue(testJob1.toString().endsWith("\n"));//?
    }

    @Test
    public void testToStringContainsFieldLabels(){
        String[] jobSplit = toStringJob.toString().split("\n");
        assertEquals(jobSplit[1].split(":")[0], "ID");
        assertEquals(jobSplit[2].split(":")[0], "Name");
        assertEquals(jobSplit[3].split(":")[0], "Employer");
        assertEquals(jobSplit[4].split(":")[0], "Location");
        assertEquals(jobSplit[5].split(":")[0], "Position Type");
        assertEquals(jobSplit[6].split(":")[0], "Core Competency");
    }


}//JobTest class
