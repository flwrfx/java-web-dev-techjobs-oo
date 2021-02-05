package org.launchcode.techjobs_oo.Tests;

import org.junit.Before;
import org.junit.Test;
import org.launchcode.techjobs_oo.*;

import static org.junit.Assert.*;

public class JobTest {
    Job testJob1;
    Job testJob2;

    @Before
    public void createJobObjects(){
        testJob1 = new Job();
        testJob2 = new Job();
    }

    @Test
    public void testSettingJobId() {
        assertFalse(testJob1.getId() == testJob2.getId());//checks that the two separate job objects have two separate IDs
        assertTrue(testJob2.getId() - testJob1.getId() == 1);//checks to see that the two job objects' ID's values differ by one
    }

    @Test
    public void testJobConstructorSetsAllFields(){
        Job constructorJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
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
    public void testJobsForEquality(){
        Job equalityJob1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job equalityJob2 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertFalse(equalityJob1.equals(equalityJob2));
    }

}//JobTest class
