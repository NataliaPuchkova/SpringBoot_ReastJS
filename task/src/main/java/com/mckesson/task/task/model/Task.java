package com.mckesson.task.task.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;

public class Task {
    private String text;
    private OffsetDateTime date;

    @Override public String toString() {
        return String.format("%s (time: %d)", date.format(DateTimeFormatter.ISO_DATE_TIME));
    }

    public void setText(String ssss) {
        this.text = ssss;
    }

    public void setDate(OffsetDateTime ssss) {
        this.date = ssss;
    }

    public String getText(){ return text;}

    public OffsetDateTime getDate() {return date; }
}
