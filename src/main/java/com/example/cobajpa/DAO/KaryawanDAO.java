package com.example.cobajpa.DAO;

import java.util.List;


import com.example.cobajpa.model.Karyawan;
import com.example.cobajpa.model.Login;

public interface KaryawanDAO {
	public List<Karyawan> getAllKaryawan();
	public Karyawan getByIdKaryawan(long id);
	public void SaveOrUpdateKaryawan(Karyawan karyawan, Login login);
	public void deleteIDKaryawan(long id);
	public void deleteKaryawan(Karyawan karyawan);
	public void SaveOrUpdateKaryawan1(Karyawan karyawan);
	
	public List<Karyawan> getByDepartemen(long id);


}
