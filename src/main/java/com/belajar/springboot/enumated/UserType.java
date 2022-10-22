package com.belajar.springboot.enumated;

public enum UserType {
    ADMIN("Admin"), USER("User");
    private String label;

    UserType(String label) {
        this.label = label;
    }
    public String getLabel(){return label;}
}
