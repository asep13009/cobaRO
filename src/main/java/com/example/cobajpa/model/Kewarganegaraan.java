package com.example.cobajpa.model;

public enum Kewarganegaraan {
	
    WNA("Warga Negara Asing"),
    WNI("Warga Negara Indonesia");
	
	
	private String displayName;

	Kewarganegaraan(final String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
