package com.example.cobajpa.service;


import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cobajpa.DAO.KaryawanDAO;
import com.example.cobajpa.model.Karyawan;
import com.example.cobajpa.model.Login;
import com.example.cobajpa.repository.KaryawanRepository;
import com.example.cobajpa.repository.LoginRepository;




@Service
public class KaryawanService implements KaryawanDAO {
	
	@Autowired
	KaryawanRepository dataKaryawanRepository;
	@Autowired
	LoginRepository loginRepository;
	@Autowired
	DepartemenService ds;
	
	
	@Override
	public List<Karyawan> getAllKaryawan() {
		List<Karyawan> karyawans = new ArrayList<>();
		dataKaryawanRepository.findAll().forEach(karyawans::add);
		return karyawans;
		
	}
	@Override
	public Karyawan getByIdKaryawan(long id) {
		Karyawan karyawan=dataKaryawanRepository.findById(id).get();
		return karyawan;
	}
	@Override
	public void SaveOrUpdateKaryawan(Karyawan karyawan, Login login) {
		dataKaryawanRepository.save(karyawan);
		login.setKaryawan(karyawan);
		loginRepository.save(login);
	}
	@Override
	public void SaveOrUpdateKaryawan1(Karyawan karyawan) {
		dataKaryawanRepository.save(karyawan);
	}
	@Override
	public void deleteIDKaryawan(long id) {
		dataKaryawanRepository.deleteById(id);
		
	}
	@Override
	public void deleteKaryawan(Karyawan karyawan) {
		dataKaryawanRepository.delete(karyawan);
		
	}
	
	
	public List<Karyawan> getAllKaryawanBuatRes() {
		List<Karyawan> karyawans = new ArrayList<>();
		dataKaryawanRepository.findByIDDepartemen(1).forEach(karyawans::add);
		return karyawans;
		
	}
	
	
	@Override
	public List<Karyawan> getByDepartemen(long id) {
		List<Karyawan> lk = new ArrayList<>();
		dataKaryawanRepository.findByDepartemen(ds.getById(id)).forEach(lk::add);
		return lk;
	}
	
	public void SaveOrUpdateWithEmail(Karyawan k,Login login) {
		dataKaryawanRepository.save(k);
		login.setKaryawan(k);
		loginRepository.save(login);
	}
	
	public List<Karyawan>ListKaryawanByActive(){
		return  dataKaryawanRepository.ListKaryawanByActive();
	}
	
	
}
