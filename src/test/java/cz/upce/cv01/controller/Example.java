package cz.upce.cv01.controller;

import cz.upce.cv01.domain.AppUser;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Example {
    public static AppUser EXISTING = new AppUser(100L, "testUser01", "pass45", true, LocalDateTime.now(), LocalDateTime.now());
}
