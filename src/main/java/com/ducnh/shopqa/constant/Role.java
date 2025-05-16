package com.ducnh.shopqa.constant;

public enum Role {
    USER("user"),
    ADMIN("admin");

    private String role;

    private Role(String role) {
        this.role = role;
    }

    public static Role fromString(String role) {
        for (Role r : Role.values()) {
            if (r.getRole().equalsIgnoreCase(role)) {
                return r;
            }
        }
        throw new IllegalArgumentException("No enum constant " + Role.class.getCanonicalName() + "." + role);
    }

    public String getRole() {
        return role;
    }
}
