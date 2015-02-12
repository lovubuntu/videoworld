package com.thoughtworks.videorental.domain;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

public class MovieTest {

    @Test
    public void shouldBeAbleToCreateNewlyReleasedMovie() throws Exception {
        Movie newlyReleasedMovie = new Movie("American Sniper", true);
        assertTrue(newlyReleasedMovie.isNewlyReleased());
    }

    @Test
    public void shouldBeAbleToCreateOldMovie() throws Exception {
        Movie oldMovie = new Movie("Older American Sniper", false);
        assertFalse(oldMovie.isNewlyReleased());
    }

    @Test
    public void shouldCharge$1EachDayForOldMovie() throws Exception {
        Movie oldMovie = new Movie("Terminator", false);
        assertEquals(2.0, oldMovie.getCharge(2));
    }

    @Test
    public void shouldCharge$3UpTo2DaysForNewlyReleasedMovie() throws Exception {
        Movie newMovie = new Movie("American Sniper", true);
        assertEquals(3.0, newMovie.getCharge(1));
        assertEquals(3.0, newMovie.getCharge(2));
    }

    @Test
    public void shouldCharge$2PerDayAfter2daysForNewlyReleasedMovie() throws Exception {
        Movie newMovie = new Movie("American Sniper", true);
        assertEquals(5.0, newMovie.getCharge(3));
        assertEquals(7.0, newMovie.getCharge(4));
    }

}