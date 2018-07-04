package com.example.cobajpa.model;

public enum JenisKelamin {
	Laki("Laki-Laki"),
	Perempuan("Perempuan");
	
	
	
	
	private String displayName;
	
	 public boolean isSelected(String nama) {
	    	if (nama==this.displayName) {
				return true;
			}else {
				return false;
			}
	    }

	JenisKelamin(final String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
