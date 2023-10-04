package org.example.databaseQuery;

import org.example.databaseQuery.queryClasses.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Date;

import static org.junit.jupiter.api.Assertions.*;

class DatabaseQueryServiceTest {

    DatabaseQueryService queryService;
    @BeforeEach
    void initDatabaseQueryService(){
        queryService = new DatabaseQueryService();
    }
    @Test
    void testFindMaxProjectsClient() {
        MaxProjectCountClient[] expected = new MaxProjectCountClient[]{
                new MaxProjectCountClient("Bogdan",3),
                new MaxProjectCountClient("Oleg",3)
        };
        assertArrayEquals(expected,queryService.findMaxProjectsClient().toArray());
    }

    @Test
    void testFindLongestProject() {
        Project expected = new Project(1, 1,
                Date.valueOf("2017-08-01"), Date.valueOf("2022-11-23"));
        assertEquals(expected,queryService.findLongestProject());
    }


    @Test
    void testFindMaxSalaryWorker() {
        Worker expected = new Worker(3, Date.valueOf("1988-07-20"),
                Worker.Level.Senior, 6000, "Maksym");
        assertEquals(expected,queryService.findMaxSalaryWorker());
    }

    @Test
    void testFindYoungestOldestWorkers() {
        AgeWorker[] expected = new AgeWorker[]{
          new AgeWorker(AgeWorker.Type.OLDEST,"Maksym",Date.valueOf("1988-07-20")),
          new AgeWorker(AgeWorker.Type.YOUNGEST,"Nazar",Date.valueOf("1997-05-22"))
        };
        assertArrayEquals(expected,queryService.findYoungestOldestWorkers().toArray());
    }
    @Test
    void testGetProjectsPrices() {
        ProjectPrice[] expectedProjectPrices = new ProjectPrice[]{
                new ProjectPrice("Project A", 730400),
                new ProjectPrice("Project B", 727650),
                new ProjectPrice("Project C", 194300),
                new ProjectPrice("Project D", 180000),
                new ProjectPrice("Project E", 129500),
                new ProjectPrice("Project F", 108800),
                new ProjectPrice("Project G", 51000),
                new ProjectPrice("Project H", 38150),
                new ProjectPrice("Project I", 25650),
                new ProjectPrice("Project J", 13200)
        };
        assertArrayEquals(expectedProjectPrices,queryService.getProjectsPrices().toArray());
    }
}